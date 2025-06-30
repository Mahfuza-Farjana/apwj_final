package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.BorrowRecord;
import com.Project.LibraryManagement.Repository.BorrowRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowService {
    private BorrowRecordRepository borrowRepo;

    public void borrowBook(BorrowRecord record) {
        borrowRepo.borrowBook(record);
    }

    public void returnBook(int recordId, LocalDate returnDate) {
        borrowRepo.returnBook(recordId, returnDate);
    }

    public List<BorrowRecord> getBorrowedBooks(int userId) {
        return borrowRepo.getBorrowedByUser(userId);
    }

    public List<BorrowRecord> getOverdueBooks() {
        return borrowRepo.getOverdueRecords(LocalDate.now());
    }

}
