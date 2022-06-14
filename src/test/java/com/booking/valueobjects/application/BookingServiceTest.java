package com.booking.valueobjects.application;

import com.booking.valueobjects.domain.Booking;
import com.booking.valueobjects.domain.BookingRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class BookingServiceTest {

    @MockBean
    private BookingRepository repository;

    @Autowired
    private BookingService service;

    @Test
    @DisplayName("Save method should return Booking object")
    void save_properlyData_shouldReturnBooking() {
        //given
        Booking booking = new Booking(1L, new Date(), new Date());
        given(repository.save(any(Booking.class))).willReturn(booking);
        //when
        Booking bookingSaved = service.save(booking);
        //then
        then(bookingSaved.id()).isEqualTo(1L);
        BDDMockito.then(repository).should().save(any(Booking.class));
    }

}