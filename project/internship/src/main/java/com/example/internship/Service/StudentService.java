package com.example.internship.Service;

import com.example.internship.Entity.StudentProfile;
import com.example.internship.Repository.StudentProfileRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentProfileRepo studentProfileRepo;

    public StudentService(StudentProfileRepo studentProfileRepo) {
        this.studentProfileRepo = studentProfileRepo;
    }

    public StudentProfile getProfileByUserId(int userId) {
        return studentProfileRepo.getByUserId(userId);
    }

    public void updateProfile(StudentProfile studentProfile) {
        studentProfileRepo.update(studentProfile);
    }
}
