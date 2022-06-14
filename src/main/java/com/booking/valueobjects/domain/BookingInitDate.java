package com.booking.valueobjects.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class BookingInitDate {

    private Date value;

    public BookingInitDate(Date value) {
        this.value = value;
    }
}
