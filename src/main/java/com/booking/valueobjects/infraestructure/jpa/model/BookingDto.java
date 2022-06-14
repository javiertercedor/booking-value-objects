package com.booking.valueobjects.infraestructure.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    
    @Id
    @GeneratedValue
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/YYYY")
    private Date initDate;
    @DateTimeFormat(pattern = "dd/MM/YYYY")
    private Date finishDate;
}
