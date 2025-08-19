package com.example.participant.controller;

import com.example.participant.model.Participant;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/participants")
public class ParticipantController {
    private final Map<Long, Participant> store = new HashMap<>();
    private long currentId = 1;

    @GetMapping
    public Collection<Participant> getAll() {
        return store.values();
    }

    @GetMapping("/{id}")
    public Participant getById(@PathVariable Long id) {
        return store.get(id);
    }

    @PostMapping
    public Participant create(@RequestBody Participant item) {
        item.setId(currentId++);
        store.put(item.getId(), item);
        return item;
    }

    @PutMapping("/{id}")
    public Participant update(@PathVariable Long id, @RequestBody Participant item) {
        item.setId(id);
        store.put(id, item);
        return item;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        store.remove(id);
    }
}
