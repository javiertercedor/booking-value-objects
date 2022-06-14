package com.booking.valueobjects;

import com.booking.valueobjects.application.BookingService;
import com.booking.valueobjects.domain.Booking;
import com.booking.valueobjects.infraestructure.api.model.BookingRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private BookingService service;

    @Test
    @DisplayName("Testing API Booking creation url with properly object")
    void create_properlyDataObject_urlShouldReturn200() throws Exception {
        //given
        BookingRequest request = new BookingRequest(1L, new Date(), new Date());
        given(service.save(any())).willReturn(new Booking(1L, new Date(), new Date()));
        //when then
        mockMvc.perform(post("/booking")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(serializeObject(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value("1"));
        
        then(service).should().save(any());
    }
    
    private String serializeObject(BookingRequest request){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
