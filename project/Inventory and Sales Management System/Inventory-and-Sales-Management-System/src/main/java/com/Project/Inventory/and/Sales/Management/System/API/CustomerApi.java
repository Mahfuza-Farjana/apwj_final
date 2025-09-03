package com.Project.Inventory.and.Sales.Management.System.API;


import com.Project.Inventory.and.Sales.Management.System.Entity.Customer;
import com.Project.Inventory.and.Sales.Management.System.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerApi {

    private final CustomerService customerService;

    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    // GET all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllUsers());
    }

    // GET customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Customer user = customerService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    // POST create customer
    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        try {
            customerService.createUser(customer);
            return ResponseEntity.ok("Customer created successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to create customer: " + e.getMessage());
        }
    }

    // PUT update customer
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(id);
        try {
            customerService.updateUser(customer);
            return ResponseEntity.ok("Customer updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update customer: " + e.getMessage());
        }
    }

    // DELETE customer
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        customerService.deleteUser(id);
        return ResponseEntity.ok("Customer deleted successfully.");
    }
}