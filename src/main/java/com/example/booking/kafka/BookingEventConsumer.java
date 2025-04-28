package com.example.booking.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookingEventConsumer {

    @KafkaListener(topics = "booking-events", groupId = "booking-group")
    public void onBookingEvent(String event) {
        System.out.println("Received booking event: " + event);
    }
}
