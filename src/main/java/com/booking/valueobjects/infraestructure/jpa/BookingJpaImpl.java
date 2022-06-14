package com.booking.valueobjects.infraestructure.jpa;

import com.booking.valueobjects.infraestructure.jpa.model.BookingDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingJpaImpl extends JpaRepository<BookingDto, Long> {
}
