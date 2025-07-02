package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.BorrowRecord;
import com.Project.LibraryManagement.Repository.BorrowRecordRepository;
import com.Project.LibraryManagement.Repository.BookRepository;
import com.Project.LibraryManagement.Entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository, BookRepository bookRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.bookRepository = bookRepository;
    }

    public void borrowBook(BorrowRecord record) {

        Book book = bookRepository.getById(record.getBookId());
        if (book == null || book.getQuantity() <= 0 || Boolean.FALSE.equals(book.getIsAvailable())) {
            throw new IllegalStateException("Book is not available for borrowing.");
        }


        borrowRecordRepository.borrowBook(record);


        book.setQuantity(book.getQuantity() - 1);
        book.setIsAvailable(book.getQuantity() > 0);
        bookRepository.update(book);
    }

    public void returnBook(int recordId) {

        BorrowRecord record = borrowRecordRepository.getBorrowedByUser(0).stream()
                .filter(r -> r.getId().equals(recordId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Record not found"));


        borrowRecordRepository.returnBook(recordId, LocalDate.now());


        Book book = bookRepository.getById(record.getBookId());
        if (book != null) {
            book.setQuantity(book.getQuantity() + 1);
            book.setIsAvailable(true);
            bookRepository.update(book);
        }
    }

    public List<BorrowRecord> getBorrowedByUser(int userId) {
        return borrowRecordRepository.getBorrowedByUser(userId);
    }

    public List<BorrowRecord> getOverdueRecords(LocalDate today) {
        return borrowRecordRepository.getOverdueRecords(today);
    }
}
