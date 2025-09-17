package com.example.participant.irepository;
import com.example.participant.model.Customer;
import java.util.List;
public interface ICustomerRepository { List<Customer> findAll(); Customer save(Customer c); }
