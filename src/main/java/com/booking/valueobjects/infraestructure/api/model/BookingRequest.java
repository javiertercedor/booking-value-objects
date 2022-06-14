package com.booking.valueobjects.infraestructure.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

    private Long id;
    private Date initDate;
    private Date finishDate;
}
