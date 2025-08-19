package com.example.ticket.controller;

import com.example.ticket.model.Ticket;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final Map<Long, Ticket> store = new HashMap<>();
    private long currentId = 1;

    @GetMapping
    public Collection<Ticket> getAll() {
        return store.values();
    }

    @GetMapping("/{id}")
    public Ticket getById(@PathVariable Long id) {
        return store.get(id);
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket item) {
        item.setId(currentId++);
        store.put(item.getId(), item);
        return item;
    }

    @PutMapping("/{id}")
    public Ticket update(@PathVariable Long id, @RequestBody Ticket item) {
        item.setId(id);
        store.put(id, item);
        return item;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        store.remove(id);
    }
}
