package com.booking.valueobjects.infraestructure.jpa;

import com.booking.valueobjects.domain.Booking;
import com.booking.valueobjects.domain.BookingRepository;
import com.booking.valueobjects.infraestructure.jpa.model.BookingDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BookingJpaRepositoryImpl implements BookingRepository {

    private final BookingJpaImpl repository;

    @Override
    public Booking save(Booking booking) {
        final BookingDto save = repository.save(new BookingDto(booking.id(), booking.initDate(), booking.finishDate()));
        return Booking.createBooking(save.getId(), save.getInitDate(), save.getFinishDate());
    }
}
