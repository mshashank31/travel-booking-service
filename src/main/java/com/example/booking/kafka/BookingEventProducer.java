package com.example.booking.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public BookingEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishBooking(String bookingJson) {
        kafkaTemplate.send("booking-events", bookingJson);
    }
}
