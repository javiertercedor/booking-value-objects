package com.booking.valueobjects.domain;

import com.booking.valueobjects.domain.exception.DataDomainException;
import lombok.Getter;

import java.util.Date;

@Getter
public class BookingInitDate {

    private Date value;

    public BookingInitDate(Date value) {
        setValue(value);
    }

    private void setValue(Date value) {
        final boolean isValueBeforeToday = value.before(new Date());
        if (isValueBeforeToday) {
            throw new DataDomainException("Init date must start after today");
        }
        this.value = value;
    }
}
