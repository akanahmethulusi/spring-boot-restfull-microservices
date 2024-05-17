package at.codefabrik.exercise.controller;

import at.codefabrik.exercise.model.Customer;
import at.codefabrik.exercise.services.CustomerServices;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer(){
        List<Customer> customers = customerServices.getCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id){
        Customer customerId = customerServices.getCustomerById(id);
        return new ResponseEntity<>(customerId, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer createdCustomer = customerServices.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id){
        customerServices.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
