package com.example.participant.service;
import com.example.participant.dto.CustomerDTO;
import com.example.participant.model.Customer;
import com.example.participant.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CustomerService {
    @Autowired private CustomerRepository repo;
    @Autowired private ModelMapper mapper;
    public List<CustomerDTO> getAll() { return repo.findAll().stream().map(c -> mapper.map(c, CustomerDTO.class)).collect(Collectors.toList()); }
    public CustomerDTO create(CustomerDTO dto) { Customer c = mapper.map(dto, Customer.class); repo.save(c); return dto; }
}
