package com.booking.valueobjects.domain;

import com.booking.valueobjects.domain.exception.DataDomainException;
import lombok.Getter;

import java.util.Date;

@Getter
public class BookingInitDate {

    private Date value;

    public BookingInitDate(Date value) {
        if (value.before(new Date())) {
            throw new DataDomainException("Init date must start after today");
        }
        this.value = value;
    }
}
