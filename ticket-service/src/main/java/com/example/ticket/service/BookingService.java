package com.example.ticket.service;
import com.example.ticket.dto.BookingDTO;
import com.example.ticket.model.Booking;
import com.example.ticket.repository.BookingRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookingService {
    @Autowired private BookingRepository repo;
    @Autowired private ModelMapper mapper;
    public List<BookingDTO> getAll() { return repo.findAll().stream().map(b -> mapper.map(b, BookingDTO.class)).collect(Collectors.toList()); }
    public BookingDTO create(BookingDTO dto) { Booking b = mapper.map(dto, Booking.class); repo.save(b); return dto; }
}
