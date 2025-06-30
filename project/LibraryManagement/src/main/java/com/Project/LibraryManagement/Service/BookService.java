package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.Book;
import com.Project.LibraryManagement.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.getAll();
    }

    public Book getBookById(int id) {
        return bookRepo.getById(id);
    }

    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public void updateBook(Book book) {
        bookRepo.update(book);
    }

    public void deleteBook(int id) {
        bookRepo.delete(id);
    }

}
