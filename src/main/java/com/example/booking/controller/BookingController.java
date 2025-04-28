package com.example.booking.controller;

import com.example.booking.kafka.BookingEventProducer;
import com.example.booking.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingEventProducer producer;
    private final BookingService bookingService;

    public BookingController(BookingEventProducer producer, BookingService bookingService) {
        this.producer = producer;
        this.bookingService = bookingService;
    }

    @PostMapping("/create/{bookingId}")
    public ResponseEntity<String> create(@PathVariable String bookingId) {
        String bookingJson = String.format("{"bookingId": "%s"}", bookingId);
        producer.publishBooking(bookingJson);
        return ResponseEntity.ok("Booking created: " + bookingId);
    }

    @GetMapping("/details/{bookingId}")
    public ResponseEntity<String> details(@PathVariable String bookingId) {
        String details = bookingService.getBookingDetails(bookingId);
        return ResponseEntity.ok(details);
    }
}
