package com.example.ticket.controller;
import com.example.ticket.dto.BookingDTO;
import com.example.ticket.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired private BookingService service;
    @GetMapping public List<BookingDTO> all() { return service.getAll(); }
    @PostMapping public BookingDTO create(@RequestBody BookingDTO dto) { return service.create(dto); }
}
