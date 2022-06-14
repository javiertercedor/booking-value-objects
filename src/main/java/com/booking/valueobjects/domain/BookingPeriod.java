package com.booking.valueobjects.domain;

import com.booking.valueobjects.domain.exception.DataDomainException;
import lombok.Getter;

import java.util.Date;

@Getter
public class BookingPeriod {

    private BookingInitDate initDate;
    private BookingFinishDate finishDate;

    public BookingPeriod(Date initDate, Date finishDate) {
        this.initDate = new BookingInitDate(initDate);
        this.finishDate = new BookingFinishDate(finishDate);

        checkProperlyRangeDates();
    }

    private void checkProperlyRangeDates() {
        final boolean isInitDateAfterFinishDate = this.initDate.getValue().after(this.finishDate.getValue());
        if (isInitDateAfterFinishDate) {
            throw new DataDomainException("Finish date must be after init date");
        }
    }
}
