package com.Project.LibraryManagement.API;

import com.Project.LibraryManagement.Entity.Reservation;
import com.Project.LibraryManagement.Service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApi {

    private final ReservationService reservationService;

    public ReservationApi(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Reserve a book
    @PostMapping("/reserve")
    public ResponseEntity<Void> reserveBook(@RequestParam int userId, @RequestParam int bookId) {
        reservationService.reserveBook(userId, bookId);
        return ResponseEntity.ok().build();
    }

    // Get reservations by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable int userId) {
        return ResponseEntity.ok(reservationService.getReservationsByUser(userId));
    }

    // Cancel a reservation
    @PostMapping("/cancel/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable int id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.ok().build();
    }

    // Fulfill a reservation
    @PostMapping("/fulfill/{id}")
    public ResponseEntity<Void> fulfillReservation(@PathVariable int id) {
        reservationService.fulfillReservation(id);
        return ResponseEntity.ok().build();
    }
}
