package com.micro.BookSystem.controller;

import com.micro.BookSystem.entity.reservation.reservation;
import com.micro.BookSystem.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@Validated
public class reservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Boolean> insertReservation(@Valid @RequestBody reservation reservation) {
        boolean result = reservationService.insertReservation(reservation);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Boolean> deleteReservation(@PathVariable int reservationId) {
        boolean result = reservationService.deleteReservation(reservationId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<reservation> selectReservationById(@PathVariable int reservationId) {
        reservation result = reservationService.selectReservationById(reservationId);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<reservation>> selectReservationByUserId(@PathVariable int userId) {
        List<reservation> result = reservationService.selectReservationsByUserId(userId);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<reservation>> selectReservationByBookId(@PathVariable int bookId) {
        List<reservation> result = reservationService.selectReservationsByBookId(bookId);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<reservation>> selectAllReservations() {
        List<reservation> result = reservationService.selectAllReservations();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/lock/{bookId}")
    public ResponseEntity<Boolean> lockBookById(@PathVariable int bookId) {
        boolean result = reservationService.lockBookById(bookId);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<Boolean> updateReservation(@Valid @RequestBody reservation reservation) {
        boolean result = reservationService.updateReservation(reservation);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{userId}/book/{bookId}")
    public ResponseEntity<List<reservation>> selectReservationsByUserIdAndBookId(@PathVariable int userId, @PathVariable int bookId) {
        List<reservation> result = reservationService.selectReservationsByUserIdAndBookId(userId, bookId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/return/{reservationId}")
    public ResponseEntity<Boolean> returnBook(@PathVariable int reservationId) {
        boolean result = reservationService.returnBook(reservationId);
        return ResponseEntity.ok(result);
    }
}
