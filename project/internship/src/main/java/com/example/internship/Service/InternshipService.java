package com.example.internship.Service;

import com.example.internship.Entity.Internship;
import com.example.internship.Repository.InternshipRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InternshipService {
    public InternshipRepo internshipRepo;

    public InternshipService(InternshipRepo internshipRepo) {
        this.internshipRepo = internshipRepo;
    }

    public List<Internship> getAllInternships() {
        return internshipRepo.getAll();
    }

    public void addInternship(Internship internship) {
        internshipRepo.insert(internship);
    }

    public void updateInternship(Internship internship) {
        internshipRepo.update(internship);
    }

    public void deleteInternship(int id) {
        internshipRepo.delete(id);
    }

    public List<Internship> searchInternships(String keyword) {
        return internshipRepo.searchByTitle(keyword);
    }

    public List<Internship> getUpcomingDeadlines(int daysAhead) {
        LocalDate withinDate = LocalDate.now().plusDays(daysAhead);
        return internshipRepo.getUpcomingDeadlines(withinDate);
    }
}
