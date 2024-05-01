//package com.example.Software.project.Controller.Forgetpass;
//import com.example.Software.project.Entity.Forgetpass.UpdateUser;
//import com.example.Software.project.Repo.Forgetpass.UpdateUserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Random;
//
//@RestController
//@RequestMapping("/forgot-password")
//public class ForgotPasswordController {
//
//    @Autowired
//    private UpdateUserRepo userRepository;
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @PostMapping("/send-otp")
//    public void sendOTP(@RequestParam String email) {
//        // Generate OTP
//        String otp = generateOTP();
//
//        // Send OTP via email
//        sendOTPEmail(email, otp);
//
//        // Update user record with OTP
//        UpdateUser user = userRepository.findByEmail(email);
//        if (user != null) {
//            user.setOtp(otp);
//            userRepository.save(user);
//        }
//    }
//
//    @PostMapping("/verify-otp")
//    public void verifyOTP(@RequestParam String email, @RequestParam String otp, @RequestParam String newPassword) {
//        // Check if OTP matches
//        UpdateUser user = userRepository.findByEmailAndOtp(email, otp);
//        if (user != null) {
//            // Update password
//            user.setPassword(newPassword);
//            user.setOtp(null); // Clear OTP
//            userRepository.save(user);
//        }
//    }
//
//    private String generateOTP() {
//        Random random = new Random();
//        int otp = 100000 + random.nextInt(900000);
//        return String.valueOf(otp);
//    }
//
//    private void sendOTPEmail(String email, String otp) {
//        // Implement logic to send email with OTP
//    }
//}