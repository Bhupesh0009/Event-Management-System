package com.example.participant.repository;
import com.example.participant.irepository.ICustomerRepository;
import com.example.participant.model.Customer;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository {
    private final List<Customer> customers = new ArrayList<>();
    public List<Customer> findAll() { return customers; }
    public Customer save(Customer c) { customers.add(c); return c; }
}
