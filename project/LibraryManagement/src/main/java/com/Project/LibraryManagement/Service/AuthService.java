package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.PasswordResetToken;
import com.Project.LibraryManagement.Entity.Role;
import com.Project.LibraryManagement.Entity.User;
import com.Project.LibraryManagement.Repository.PasswordResetTokenRepository;
import com.Project.LibraryManagement.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthService {
    private UserRepository userRepo;


    private PasswordResetTokenRepository tokenRepo;


    private PasswordEncoder passwordEncoder;

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.User);
        userRepo.save(user);
    }

    public User login(String email, String password) {
        User user = userRepo.getByEmail(email);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new RuntimeException("Invalid credentials");
    }

    public void forgotPassword(String email) {
        User user = userRepo.getByEmail(email);
        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken(
                null, user.getId(), token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));
        tokenRepo.save(resetToken);

    }

    public void resetPassword(String token, String newPassword) {
        PasswordResetToken reset = tokenRepo.findByToken(token);
        if (reset.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expired");
        }
        User user = userRepo.getById(reset.getUserId());
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.update(user);
    }
}
