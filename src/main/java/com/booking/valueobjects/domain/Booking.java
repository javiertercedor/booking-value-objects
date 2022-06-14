package com.booking.valueobjects.domain;

import java.util.Date;

public class Booking {

    private BookingId id;
    private BookingPeriod period;

    public static Booking createBooking(Long id, Date initDate, Date finishDate) {
        return new Booking(id, initDate, finishDate);
    }

    private Booking(Long id, Date initDate, Date finishDate) {
        this.id = new BookingId(id);
        this.period = new BookingPeriod(initDate, finishDate);
    }

    public Long id() {
        return this.id.getValue();
    }

    public Date initDate() {
        return this.period.initDate.getValue();
    }

    public Date finishDate() {
        return this.period.finishDate.getValue();
    }
}
