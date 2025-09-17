package com.example.event.irepository;

import com.example.event.model.Event;
import java.util.List;

public interface IEventRepository {
    List<Event> findAll();
    Event save(Event event);
}
