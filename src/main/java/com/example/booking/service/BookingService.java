package com.example.booking.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${booking.api.base-url}")
    private String bookingBaseUrl;

    public String getBookingDetails(String bookingId) {
        String url = String.format("%s/details/%s", bookingBaseUrl, bookingId);
        return restTemplate.getForObject(url, String.class);
    }
}
