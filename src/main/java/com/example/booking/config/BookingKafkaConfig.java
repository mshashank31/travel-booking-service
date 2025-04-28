package com.example.booking.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingKafkaConfig {
    @Bean
    public NewTopic bookingEventsTopic() {
        return new NewTopic("booking-events", 1, (short) 1);
    }
}
