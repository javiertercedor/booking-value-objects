package com.booking.valueobjects.infraestructure.api;

import com.booking.valueobjects.application.BookingService;
import com.booking.valueobjects.domain.Booking;
import com.booking.valueobjects.infraestructure.api.model.BookingRequest;
import com.booking.valueobjects.infraestructure.api.model.BookingResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingService service;

    @PostMapping
    public ResponseEntity<BookingResponse> create(@RequestBody BookingRequest request) {
        final Booking save = service.save(new Booking(request.getId(), request.getInitDate(), request.getFinishDate()));
        return ResponseEntity.ok(new BookingResponse(save.id()));
    }
}
