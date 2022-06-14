package com.booking.valueobjects.domain;

import com.booking.valueobjects.domain.exception.DataDomainException;
import lombok.Getter;

@Getter
public class BookingId {

    private Long value;

    public BookingId(Long value) {
        setValue(value);
    }

    private void setValue(Long value) {
        if (value == null || value < 0) {
            throw new DataDomainException("Booking Id value must be greater than 0");
        }
        this.value = value;
    }
}
