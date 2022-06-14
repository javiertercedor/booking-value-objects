package com.booking.valueobjects.application;

import com.booking.valueobjects.domain.Booking;
import com.booking.valueobjects.domain.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {
    
    private final BookingRepository repository;
    
    public Booking save(Booking booking) {
        return repository.save(booking);
    }
}
