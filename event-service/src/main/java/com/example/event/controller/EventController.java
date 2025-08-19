package com.example.event.controller;

import com.example.event.model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/events")
public class EventController {
    private final Map<Long, Event> store = new HashMap<>();
    private long currentId = 1;

    @GetMapping
    public Collection<Event> getAll() {
        return store.values();
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id) {
        return store.get(id);
    }

    @PostMapping
    public Event create(@RequestBody Event item) {
        item.setId(currentId++);
        store.put(item.getId(), item);
        return item;
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event item) {
        item.setId(id);
        store.put(id, item);
        return item;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        store.remove(id);
    }
}
