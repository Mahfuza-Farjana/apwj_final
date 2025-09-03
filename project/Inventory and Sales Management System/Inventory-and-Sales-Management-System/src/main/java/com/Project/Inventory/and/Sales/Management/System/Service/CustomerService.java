package com.Project.Inventory.and.Sales.Management.System.Service;

import com.Project.Inventory.and.Sales.Management.System.Entity.Customer;
import com.Project.Inventory.and.Sales.Management.System.Repository.CustomerRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class CustomerService  {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository, JdbcTemplate jdbcTemplate) {
        this.customerRepository = customerRepository;

    }



    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    public List<Customer> getAllUsers() {
        return customerRepository.getAll();
    }

    public Customer getUserById(int id) {
        return customerRepository.getById(id);
    }

    public void createUser(Customer user) {
        customerRepository.save(user);
    }

    public void updateUser(Customer user) {
        customerRepository.update(user);
    }

    public void deleteUser(int id) {
        customerRepository.delete(id);
    }
}
