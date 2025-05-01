package com.parcela.parcela_server.controller;

import com.parcela.parcela_server.entity.Booking;
import com.parcela.parcela_server.entity.Feedback;
import com.parcela.parcela_server.service.impl.BookingService;
import com.parcela.parcela_server.service.impl.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private FeedbackService feedbackService;

    // Get all bookings (admin view)
    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    // Admin cancel booking
    @DeleteMapping("/bookings/{orderId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long orderId) {
        return ResponseEntity.ok(bookingService.adminCancelBooking(orderId));
    }

    // Update order status
    @PutMapping("/bookings/{orderId}/status")
    public ResponseEntity<Booking> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam String status) {
        return ResponseEntity.ok(bookingService.updateOrderStatus(orderId, status));
    }

    // Get all feedbacks
    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }
}