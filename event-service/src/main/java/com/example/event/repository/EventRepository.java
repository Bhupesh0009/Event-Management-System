package com.example.event.repository;

import com.example.event.irepository.IEventRepository;
import com.example.event.model.Event;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepository implements IEventRepository {

    private final List<Event> events = new ArrayList<>();

    @Override
    public List<Event> findAll() {
        return events;
    }

    @Override
    public Event save(Event event) {
        events.add(event);
        return event;
    }
}
