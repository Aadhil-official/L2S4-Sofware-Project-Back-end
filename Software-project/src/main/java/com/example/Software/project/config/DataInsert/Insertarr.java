package com.example.Software.project.config.DataInsert;

import com.example.Software.project.Entity.Login.AppUser;
import com.example.Software.project.Entity.Login.LogRole;
import com.example.Software.project.Entity.Login.Role;
import com.example.Software.project.Repo.Login.AppUserRepo;
import com.example.Software.project.Repo.Login.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Configuration
public class Insertarr {

    private final PasswordEncoder encoder;
    private final JavaMailSender emailSender;
    private final AppUserRepo userRepository;
    private final RoleRepo repository;

    public Insertarr(PasswordEncoder encoder, JavaMailSender emailSender, AppUserRepo userRepository, RoleRepo repository) {
        this.encoder = encoder;
        this.emailSender = emailSender;
        this.userRepository = userRepository;
        this.repository = repository;
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            // Check if roles exist, if not, create them
            createRolesIfNotExist();

            // Check if admin user exists
            if (!userRepository.existsByEmail("aadhil8336@gmail.com") && !userRepository.existsByUsername("Admin")) {
                // Create a new admin user
                String pass = generateNumber();
                AppUser adminUser = new AppUser();
                adminUser.setUsername("Admin");
                adminUser.setEmail("aadhil8336@gmail.com");
                adminUser.setPassword(encoder.encode(pass));
                adminUser.setUsergroup("anadmin");
                adminUser.setAddress("ArctictPvt(Ltd)");
                adminUser.setTel("+94750213273");
                // Assign role to admin user
                Set<Role> roles = new HashSet<>();
                Role adminrole = repository.findByName(LogRole.ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: Role 'ADMIN' not found"));
                roles.add(adminrole);
                adminUser.setRoles(roles);

                // Save admin user
                userRepository.save(adminUser);

                // Send email to admin
                String subject = "Welcome, Admin";
                String message = "Hello Admin,\n\nYour account has been created successfully.\n\n" +
                        "Username: Admin\n" +
                        "Password: " + pass + "\n\n" +
                        "Please change your password after logging in for the first time.\n\n" +
                        "Regards,\nYour Team";

                sendEmail(adminUser.getEmail(), subject, message);
            }
        };
    }

    private void createRolesIfNotExist() {
        if (!repository.existsByName(LogRole.USER)) {
            repository.save(new Role(LogRole.USER));
        }
//        if (!repository.existsByName(LogRole.ADMIN_MODERATOR)) {
//            repository.save(new Role(LogRole.ADMIN_MODERATOR));
//        }
        if (!repository.existsByName(LogRole.ADMIN)) {
            repository.save(new Role(LogRole.ADMIN));
        }
    }

    private void sendEmail(String email, String subject, String message) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        emailSender.send(mimeMessage);
    }

    private String generateNumber() {
        Random random = new Random();
        int otpLength = 8;
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
}
