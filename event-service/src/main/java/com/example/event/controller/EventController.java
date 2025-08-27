package com.example.event.controller;

import com.example.event.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/events")
public class EventController {

    private final Map<Long, Event> store = new ConcurrentHashMap<>();
    private final AtomicLong ids = new AtomicLong(1);

    @GetMapping
    public Collection<Event> getAll() {
        return store.values();
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id) {
        Event e = store.get(id);
        if (e == null) {
            throw new ResourceNotFound("Event", id);
        }
        return e;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@RequestBody Event item) {
        long id = ids.getAndIncrement();
        item.setId(id);
        store.put(id, item);
        return item;
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event item) {
        if (!store.containsKey(id)) {
            throw new ResourceNotFound("Event", id);
        }
        item.setId(id);
        store.put(id, item);
        return item;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (store.remove(id) == null) {
            throw new ResourceNotFound("Event", id);
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class ResourceNotFound extends RuntimeException {
        public ResourceNotFound(String type, Long id) {
            super(type + " with id " + id + " not found");
        }
    }
}
