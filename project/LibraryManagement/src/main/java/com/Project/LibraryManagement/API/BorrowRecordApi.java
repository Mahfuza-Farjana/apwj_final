package com.Project.LibraryManagement.API;

import com.Project.LibraryManagement.Entity.BorrowRecord;
import com.Project.LibraryManagement.Service.BorrowRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/borrow-records")
public class BorrowRecordApi {

    private final BorrowRecordService borrowRecordService;

    public BorrowRecordApi(BorrowRecordService borrowRecordService) {
        this.borrowRecordService = borrowRecordService;
    }

    // Borrow a book
    @PostMapping("/borrow")
    public ResponseEntity<Void> borrowBook(@RequestBody BorrowRecord record) {
        borrowRecordService.borrowBook(record);
        return ResponseEntity.ok().build();
    }

    // Return a book by recordId
    @PostMapping("/return/{recordId}")
    public ResponseEntity<Void> returnBook(@PathVariable int recordId) {
        borrowRecordService.returnBook(recordId);
        return ResponseEntity.ok().build();
    }

    // Get all borrow records of a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BorrowRecord>> getBorrowedByUser(@PathVariable int userId) {
        return ResponseEntity.ok(borrowRecordService.getBorrowedByUser(userId));
    }

    // Get overdue borrow records (e.g., today’s date passed as param)
    @GetMapping("/overdue")
    public ResponseEntity<List<BorrowRecord>> getOverdueRecords(@RequestParam(required = false) String date) {
        LocalDate today = (date == null) ? LocalDate.now() : LocalDate.parse(date);
        return ResponseEntity.ok(borrowRecordService.getOverdueRecords(today));
    }
}
