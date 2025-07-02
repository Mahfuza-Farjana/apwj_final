package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.Book;
import com.Project.LibraryManagement.Repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAll();
    }

    public Book getBookById(int id) {
        return bookRepository.getById(id);
    }

    public void createBook(Book book) {

        if (book.getQuantity() != null && book.getQuantity() > 0) {
            book.setIsAvailable(true);
        } else {
            book.setIsAvailable(false);
        }
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        if (book.getQuantity() != null && book.getQuantity() > 0) {
            book.setIsAvailable(true);
        } else {
            book.setIsAvailable(false);
        }
        bookRepository.update(book);
    }

    public void deleteBook(int id) {
        bookRepository.delete(id);
    }

    public Book getBookWithCategory(int id) {
        return bookRepository.getBookWithCategory(id);
    }
}
