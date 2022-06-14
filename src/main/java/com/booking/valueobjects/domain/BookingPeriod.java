package com.booking.valueobjects.domain;

import java.util.Date;

public class BookingPeriod {
    
    public BookingInitDate initDate;
    public BookingFinishDate finishDate;
    
    public BookingPeriod (Date initDate, Date finishDate){
        this.initDate = new BookingInitDate(initDate);
        this.finishDate = new BookingFinishDate(finishDate);
    }
}
