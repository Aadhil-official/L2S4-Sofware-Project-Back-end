package com.example.Software.project.Controller.Auth;

import com.example.Software.project.Controller.Auth.Response.UserInfoResponse;
//import jakarta.validation.constraints.Email;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


import jakarta.validation.Valid;

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
                .collect(Collectors.toList());

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

        String subject="Welcome";
        String object = "pppppppp"+"This is your group"+signUpRequest.getUsergroup()+" You from"+signUpRequest.getAddress();

        sendEmail(signUpRequest.getEmail(),signUpRequest.getPassword(), subject, object);

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
        if (userRepository.existsByEmail(forEmail.getEmail())){
        String email = forEmail.getEmail();
        String trimmedEmail = email.trim();
//        logger.debug("Received request at /endpoint");
        // Generate OTP
        String otp = generateNumber();

        // Save OTP in storage
        otpStorage.put(trimmedEmail, otp);

        String subject="";
        String object = "";

        // Send OTP to user via email or SMS (not implemented)
        sendEmail(trimmedEmail, otp,subject,object);

        return ResponseEntity.ok(new MessageResponse("OTP sent successfully!"));
        }else {
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

//    private String generateNumberPass() {
//        Random random = new Random();
//        int otpLength = 8;
//        StringBuilder otp = new StringBuilder();
//        for (int i = 0; i < otpLength; i++) {
//            otp.append(random.nextInt(10));
//        }
//        return otp.toString();
//    }
}
