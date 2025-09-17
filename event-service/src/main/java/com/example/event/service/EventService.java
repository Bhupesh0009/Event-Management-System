package com.example.event.service;

import com.example.event.dto.EventDTO;
import com.example.event.model.Event;
import com.example.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream().map(event -> {
            EventDTO dto = new EventDTO();
            dto.setId(event.getId());
            dto.setName(event.getName());
            dto.setDate(event.getDate());
            dto.setLocation(event.getLocation());
            return dto;
        }).collect(Collectors.toList());
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = new Event(eventDTO.getId(), eventDTO.getName(), eventDTO.getDate(), eventDTO.getLocation());
        eventRepository.save(event);
        return eventDTO;
    }
}
