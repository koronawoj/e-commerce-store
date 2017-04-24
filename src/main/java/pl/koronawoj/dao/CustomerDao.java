package pl.koronawoj.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import pl.koronawoj.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Integer> {
	Customer findByUsername(String username);
    Customer findByCustomerEmail(String customerEmail);
    List<Customer> findAll();
}
