package at.codefabrik.exercise.services;
import at.codefabrik.exercise.exception.ConflictException;
import at.codefabrik.exercise.exception.EntityNotFoundException;
import at.codefabrik.exercise.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServices {
    private List<Customer> customers;

    public List<Customer> getCustomer(){
        initCustomers();
        return customers;
    }

    private void initCustomers() {
        if(customers == null){
            Customer customer1 = new Customer();
            customer1.setId(UUID.randomUUID().toString());
            customer1.setFirstname("Michael");
            customer1.setLastname("Leinbery");

            Customer customer2 = new Customer();
            customer2.setId(UUID.randomUUID().toString());
            customer2.setFirstname("Hannes");
            customer2.setLastname("Beweg");

            customers = new ArrayList<>();
            customers.add(customer1);
            customers.add(customer2);
        }
    }

    public Customer getCustomerById(String id){
        return customers.stream()
                        .filter(customer -> customer.getId().equals(id))
                        .findFirst()
                        .orElseThrow(()-> new EntityNotFoundException(String.format("Customer id: %s not found", id)));
    }

    public Customer createCustomer(Customer customer) {
        checkExistingCustomer(customer);
        customer.setId(UUID.randomUUID().toString());
        customers.add(customer);
        return customer;
    }

    private void checkExistingCustomer(Customer customer) {
        customers.stream()
                .filter(cus->cus.getFirstname().equals(customer.getFirstname()))
                .filter(cus->cus.getLastname().equals(customer.getLastname()))
                .findFirst()
                .ifPresent(cus->{
                        throw new ConflictException(String.format("Customer with firstname: %s and lastname: %s already existing",
                                customer.getFirstname(), customer.getLastname()));
                    });
    }

    public void deleteCustomer(String id){
        customers = customers.stream()
                .filter(customer -> !customer.getId().equals(id))
                .collect(Collectors.toList());
    }
}
