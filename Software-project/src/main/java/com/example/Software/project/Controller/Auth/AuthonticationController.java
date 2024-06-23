package com.example.Software.project.Controller.Auth;

import com.example.Software.project.Controller.Auth.Response.UserInfoResponse;
//import jakarta.validation.constraints.Email;
import com.example.Software.project.Entity.DTO.AppUserDTO;
import com.example.Software.project.Entity.Forgetpass.ForEmail;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.example.Software.project.Entity.Forgetpass.UpdatePasswordRequest;
import com.example.Software.project.Entity.Login.AppUser;
import com.example.Software.project.Entity.Login.LogRole;
import com.example.Software.project.Entity.Login.Role;
import com.example.Software.project.Repo.Login.AppUserRepo;
import com.example.Software.project.Repo.Login.RoleRepo;
import com.example.Software.project.config.JwtUtils;
import com.example.Software.project.config.UserDetailsImpl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


import jakarta.validation.Valid;

import static java.util.stream.Collectors.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthonticationController {

    private final AuthenticationManager authenticationManager;

    private final AppUserRepo userRepository;

    private final RoleRepo roleRepository;

    private final PasswordEncoder encoder;

    final
    JwtUtils jwtUtils;

    private final Map<String, String> otpStorage = new HashMap<>();


    private final JavaMailSender emailSender;

    @Autowired
    public AuthonticationController(AuthenticationManager authenticationManager, AppUserRepo userRepository, RoleRepo roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils, JavaMailSender emailSender) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
        this.emailSender = emailSender;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthonticationRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));


//        System.out.println(encoder.encode(loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(toList());

        //GrantedAuthority::getAuthority

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        userDetails.getAddress(),
                        userDetails.getUsergroup(),
                        userDetails.getTel(),
                        roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

//        String pass = generateNumberPass();


        // Create new user's account
        AppUser user = new AppUser(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getAddress(),
                signUpRequest.getUsergroup(),
                signUpRequest.getTel(),
                encoder.encode(signUpRequest.getPassword())); // Encode and save the generated password

//        System.out.println(signUpRequest);

        // Save other user details
        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(LogRole.USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is empty give correct one."));
            roles.add(userRole);
        } else {
//            System.out.println(strRoles);
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(LogRole.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
//                    case "mod":
//                        Role modRole = roleRepository.findByName(LogRole.ADMIN_MODERATOR)
//                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                        roles.add(modRole);
//                        break;
                    default:
                        Role userRole = roleRepository.findByName(LogRole.USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);

        // Save the user to the database
        userRepository.save(user);

        String subject = "Welcome";
        String object = "pppppppp" + "This is your group" + signUpRequest.getUsergroup() + " You from" + signUpRequest.getAddress();

        try {
            sendEmail(signUpRequest.getEmail(), signUpRequest.getPassword(), subject, object);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Email send is failed"));
        }

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> signOut(@RequestBody Map<String, Boolean> requestBody, HttpServletResponse response) {
        Boolean checked = requestBody.get("checked");
        if (checked != null && !checked) {
            ResponseCookie cleanJwtCookie = jwtUtils.getCleanJwtCookie();
            response.addHeader(HttpHeaders.SET_COOKIE, cleanJwtCookie.toString());
            System.out.println("Signed out");
            return ResponseEntity.ok(new MessageResponse("Signed out successfully!"));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Invalid request!"));
        }
    }


//-------------------------------------------


    @PostMapping("/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        Optional<AppUser> optionalUser = userRepository.findByEmail(updatePasswordRequest.getEmail());
        if (optionalUser.isPresent()) {
            AppUser user = optionalUser.get();
            if (validateOTP(updatePasswordRequest.getEmail(), updatePasswordRequest.getOtp())) {
                user.setPassword(encoder.encode(updatePasswordRequest.getNewPassword()));
//                System.out.println(encoder.encode(updatePasswordRequest.getNewPassword()));
                userRepository.save(user);
                return ResponseEntity.ok(new MessageResponse("Password updated successfully!"));
            } else {
                return ResponseEntity.badRequest().body(new MessageResponse("Invalid OTP!"));
            }
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("User not found with email: " + updatePasswordRequest.getEmail()));
        }
    }

    private boolean validateOTP(String email, String otp) {
        String storedOTP = otpStorage.get(email);
        return storedOTP != null && storedOTP.equals(otp);
    }

    //    private static final Logger logger = LoggerFactory.getLogger(AuthonticationController.class);
    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOTP(@RequestBody ForEmail forEmail) {
//    String email1 = requestBody.get("email");
//        System.out.println(forEmail.getEmail());
        if (userRepository.existsByEmail(forEmail.getEmail())) {
            String email = forEmail.getEmail();
            String trimmedEmail = email.trim();
//        logger.debug("Received request at /endpoint");
            // Generate OTP
            String otp = generateNumber();

            // Save OTP in storage
            otpStorage.put(trimmedEmail, otp);

            String subject = "";
            String object = "";

            // Send OTP to user via email or SMS (not implemented)
            try {
                sendEmail(trimmedEmail, otp, subject, object);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(new MessageResponse("Email send is failed"));
            }

            return ResponseEntity.ok(new MessageResponse("OTP sent successfully!"));
        } else {
            return ResponseEntity.badRequest().body((new MessageResponse("The use already exist")));
        }

    }


    private void sendEmail(String email, String password, String subject, String object) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(object + password);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        emailSender.send(message);
    }

    private String generateNumber() {
        Random random = new Random();
        int otpLength = 6;
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

    @PostMapping("/findappuser")
    public ResponseEntity<?> findUserById(@RequestParam String id) {
        try {
            Optional<AppUser> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                AppUser user = optionalUser.get();
                AppUserDTO userDto = new AppUserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getTel(), user.getAddress(), user.getUsergroup(), user.getRoles());
//                System.out.println(userDto);
                return ResponseEntity.ok().body(userDto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("User with ID " + id + " not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error fetching user: " + e.getMessage()));
        }
    }


    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@Valid @RequestBody AppUserDTO userDto) {
        try {
            Optional<AppUser> optionalUser = userRepository.findById(userDto.getId());
            String role = "";
            String username = "";
            String address = "";
            String tel = "";
            String userGroup = "";
            String email = "";
            if (optionalUser.isPresent()) {
                AppUser user = optionalUser.get();

                Set<String> userDtoRoleNames = new HashSet<>();
                for (Role role1 : userDto.getRoles()) {
                    LogRole name = role1.getName();
                    userDtoRoleNames.add(String.valueOf(name));
                }

                if (!Objects.equals(userDto.getRoles().toString(), user.getRoles().toString())) {
                    String newRoles = String.join(", ", userDtoRoleNames);
                    role = "Your role is changed with: " + newRoles + "\n";

                }
                if (!Objects.equals(userDto.getUsergroup(), user.getUsergroup())) {
                    userGroup = "Your group is changed with: " + userDto.getUsergroup() + "\n";
                }
                if (!Objects.equals(userDto.getAddress(), user.getAddress())) {
                    address = "Your address is changed with: " + userDto.getAddress() + "\n";
                }
                if (!Objects.equals(userDto.getTel(), user.getTel())) {
                    tel = "Your contact number is changed with: " + userDto.getTel() + "\n";
                }
                if (!Objects.equals(userDto.getUsername(), user.getUsername())) {
                    username = "Your username is changed with: " + userDto.getUsername() + "\n";
                }
                if (!Objects.equals(userDto.getEmail(), user.getEmail())) {
                    email = "Your email is changed with: " + userDto.getEmail() + "\n";
                }
                String subject = "Your details are updated";
                String object = username + address + userGroup + tel + role + email;
                String emailSend;
                emailSend = userDto.getEmail();

                if (!username.isEmpty() || !address.isEmpty() || !userGroup.isEmpty() || !tel.isEmpty() || !role.isEmpty() || !email.isEmpty()) {
                    sendEmail(emailSend, "", subject, object);
                }
                if ((((!userRepository.existsByUsername(userDto.getUsername())) || username.isEmpty()) && ((!userRepository.existsByEmail(userDto.getEmail())) || email.isEmpty())))
                {
//                System.out.println(user);
                    user.setUsername(userDto.getUsername());
                    user.setAddress(userDto.getAddress());
                    user.setTel(userDto.getTel());
                    user.setUsergroup(userDto.getUsergroup());
                    user.setEmail(userDto.getEmail());

//                Set<Role> roles = userDto.getRoles().stream()
//                        .map(roleName -> roleRepository.findByName(roleName.getName()))
//                        .filter(Optional::isPresent)
//                        .map(Optional::get)
//                        .collect(Collectors.toSet());

//                if(userDto.getRoles()==="admin"){
//                    user.setRoles(roles);
//                }else {
                    user.setRoles(user.getRoles());
//                }
//                System.out.println(user.getRoles());
//                List<Role> roles = userDto.getRoles().stream()
//                        .map(roleName -> roleRepository.findByName(LogRole.valueOf(roleName.toUpperCase())))
//                        .collect(Collectors.toList());
//                user.setRoles(roles);
                    // Assuming roles should not be updated here, else handle role updates similarly
                    userRepository.save(user);
                    return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
                }else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(" Username or email is already exists ");
                }
                } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + userDto.getId() + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
        }
    }

}
