package com.example.ticket.irepository;
import com.example.ticket.model.Booking;
import java.util.List;
public interface IBookingRepository { List<Booking> findAll(); Booking save(Booking b); }
