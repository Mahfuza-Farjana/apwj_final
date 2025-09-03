package com.example.internship.Service;

import com.example.internship.Entity.User;
import com.example.internship.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.getAll();
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public void approveUser(int id, boolean approved) {
        userRepo.updateApproval(id, approved);
    }

    public void deleteUser(int id) {
        userRepo.delete(id);
    }

    public void registerUser(User user) {
        userRepo.insert(user);
    }
}
