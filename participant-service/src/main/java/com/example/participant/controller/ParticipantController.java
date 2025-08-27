package com.example.participant.controller;

import com.example.participant.model.Participant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    private final Map<Long, Participant> store = new ConcurrentHashMap<>();
    private final AtomicLong ids = new AtomicLong(1);

    @GetMapping
    public Collection<Participant> getAll() {
        return store.values();
    }

    @GetMapping("/{id}")
    public Participant getById(@PathVariable Long id) {
        Participant p = store.get(id);
        if (p == null) throw new ResourceNotFound("Participant", id);
        return p;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Participant create(@RequestBody Participant item) {
        long id = ids.getAndIncrement();
        item.setId(id);
        store.put(id, item);
        return item;
    }

    @PutMapping("/{id}")
    public Participant update(@PathVariable Long id, @RequestBody Participant item) {
        if (!store.containsKey(id)) throw new ResourceNotFound("Participant", id);
        item.setId(id);
        store.put(id, item);
        return item;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (store.remove(id) == null) throw new ResourceNotFound("Participant", id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class ResourceNotFound extends RuntimeException {
        public ResourceNotFound(String type, Long id) {
            super(type + " with id " + id + " not found");
        }
    }
}
