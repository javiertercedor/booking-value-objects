package com.booking.valueobjects.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class BookingFinishDate {

    private Date value;

    public BookingFinishDate(Date value) {
        this.value = value;
    }
}
