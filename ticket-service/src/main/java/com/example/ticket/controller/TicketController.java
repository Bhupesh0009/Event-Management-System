package com.example.ticket.controller;

import com.example.ticket.model.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final Map<Long, Ticket> store = new ConcurrentHashMap<>();
    private final AtomicLong ids = new AtomicLong(1);

    @GetMapping
    public Collection<Ticket> getAll() {
        return store.values();
    }

    @GetMapping("/{id}")
    public Ticket getById(@PathVariable Long id) {
        Ticket t = store.get(id);
        if (t == null) throw new ResourceNotFound("Ticket", id);
        return t;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket create(@RequestBody Ticket item) {
        long id = ids.getAndIncrement();
        item.setId(id);
        store.put(id, item);
        return item;
    }

    @PutMapping("/{id}")
    public Ticket update(@PathVariable Long id, @RequestBody Ticket item) {
        if (!store.containsKey(id)) throw new ResourceNotFound("Ticket", id);
        item.setId(id);
        store.put(id, item);
        return item;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (store.remove(id) == null) throw new ResourceNotFound("Ticket", id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class ResourceNotFound extends RuntimeException {
        public ResourceNotFound(String type, Long id) {
            super(type + " with id " + id + " not found");
        }
    }
}
