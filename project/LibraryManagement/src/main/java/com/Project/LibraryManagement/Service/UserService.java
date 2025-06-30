package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.User;
import com.Project.LibraryManagement.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepo;



    public User getProfile(int userId) {
        return userRepo.getById(userId);
    }

    public void updateProfile(User user) {
        userRepo.update(user);
    }

    public void changePassword(int userId, String newPassword, String encodedPassword) {
        User user = userRepo.getById(userId);
        user.setPassword(encodedPassword);
        userRepo.update(user);
    }
}
