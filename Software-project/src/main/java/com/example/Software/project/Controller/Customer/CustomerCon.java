package com.example.Software.project.Controller.Customer;

import com.example.Software.project.Controller.Auth.MessageResponse;
import com.example.Software.project.Entity.Customer.Customer;
import com.example.Software.project.Entity.DTO.CustomerDTO;
import com.example.Software.project.Repo.Customer.CustomerRepo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class CustomerCon {

    private final CustomerRepo customerRepo;

    public CustomerCon(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        try {
            customerRepo.save(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer Added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.toString());
        }
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<?> getAllCustomers() {
        try {
            List<Customer> customers = customerRepo.findAll();
            return ResponseEntity.ok().body(customers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<?> getCustomer(@RequestParam String id) {
        try {
            Optional<Customer> customer = customerRepo.findById(id);
            return ResponseEntity.ok().body(customer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<?> updateItem(@Valid @RequestBody CustomerDTO customerDTO) {
        try {
            Optional<Customer> optionalCustomer = customerRepo.findById(customerDTO.getId());
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                customer.setCustomerName(customerDTO.getCustomerName());
                customer.setAddress(customerDTO.getAddress());
                customer.setContactNumber(customerDTO.getContactNumber());
                customer.setEmail(customerDTO.getEmail());
                customer.setLocation(customerDTO.getLocation());
                customerRepo.save(customer);
                return ResponseEntity.ok(new MessageResponse("Customer updated successfully!"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + customerDTO.getId() + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating customer: " + e.getMessage());
        }
    }

    @DeleteMapping("/dltCustomer")
    public ResponseEntity<MessageResponse> dltCustomer(@RequestParam String id) {
        Optional<Customer> optionalCustomer = customerRepo.findById(id);
        try {
            if (optionalCustomer.isPresent()) {
                customerRepo.delete(optionalCustomer.get());
                return ResponseEntity.ok(new MessageResponse("Customer deleted Successfully"));
            } else {
                return ResponseEntity.badRequest().body(new MessageResponse("Customer not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error deleting customer: " + e.getMessage()));
        }
    }

    @DeleteMapping("/clearAllCustomers")
    public ResponseEntity<MessageResponse> clearAllCustomers() {
        try {
            customerRepo.deleteAll();
            return ResponseEntity.ok(new MessageResponse("Successfully delete all customers"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error delete all customers: " + e.getMessage()));
        }
    }


}
