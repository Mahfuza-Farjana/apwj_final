package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.User;
import com.Project.LibraryManagement.Repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserService  {


    private final UserRepository userRepository;

    public UserService( UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public void deleteUser(int id) {
        userRepository.delete(id);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }
}
