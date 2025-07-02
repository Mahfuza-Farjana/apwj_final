package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.Reservation;
import com.Project.LibraryManagement.Entity.Book;
import com.Project.LibraryManagement.Repository.ReservationRepository;
import com.Project.LibraryManagement.Repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;

    public ReservationService(ReservationRepository reservationRepository, BookRepository bookRepository) {
        this.reservationRepository = reservationRepository;
        this.bookRepository = bookRepository;
    }

    public void reserveBook(int userId, int bookId) {
        Book book = bookRepository.getById(bookId);
        if (book == null || book.getQuantity() <= 0 || Boolean.FALSE.equals(book.getIsAvailable())) {
            throw new IllegalStateException("Book is not available for reservation.");
        }

        Reservation reservation = new Reservation(
                null, // ID will be auto-generated
                userId,
                bookId,
                LocalDateTime.now(),
                "PENDING"
        );

        reservationRepository.reserveBook(reservation);
    }

    public List<Reservation> getReservationsByUser(int userId) {
        return reservationRepository.getByUserId(userId);
    }

    public void cancelReservation(int reservationId) {
        reservationRepository.cancel(reservationId);
    }

    public void fulfillReservation(int reservationId) {
        reservationRepository.fulfill(reservationId);
    }
}
