package com.booking.valueobjects.domain;

import com.booking.valueobjects.domain.exception.DataDomainException;

import java.util.Date;

public class BookingPeriod {

    public BookingInitDate initDate;
    public BookingFinishDate finishDate;

    public BookingPeriod(Date initDate, Date finishDate) {
        this.initDate = new BookingInitDate(initDate);
        this.finishDate = new BookingFinishDate(finishDate);

        checkProperlyRangeDates();
    }

    private void checkProperlyRangeDates() {
        if (this.initDate.getValue().after(this.finishDate.getValue())) {
            throw new DataDomainException("Finish date must be after init date");
        }
    }
}
