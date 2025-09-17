package com.example.ticket.repository;
import com.example.ticket.irepository.IBookingRepository;
import com.example.ticket.model.Booking;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BookingRepository implements IBookingRepository {
    private final List<Booking> bookings = new ArrayList<>();
    public List<Booking> findAll() { return bookings; }
    public Booking save(Booking b) { bookings.add(b); return b; }
}
