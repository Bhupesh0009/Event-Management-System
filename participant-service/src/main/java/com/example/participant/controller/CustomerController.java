package com.example.participant.controller;
import com.example.participant.dto.CustomerDTO;
import com.example.participant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired private CustomerService service;
    @GetMapping public List<CustomerDTO> all() { return service.getAll(); }
    @PostMapping public CustomerDTO create(@RequestBody CustomerDTO dto) { return service.create(dto); }
}
