package at.codefabrik.exercise.controller;

import at.codefabrik.exercise.services.CustomerServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CustomerControllerTest {
    private CustomerController customerController;
    private CustomerServices customerServices;

    @BeforeEach
    public void setUp(){
        customerServices = Mockito.mock(CustomerServices.class);
        customerController = new CustomerController(customerServices);
    }

    @Test
    public void callCustomerService_getCustomer(){
        customerController.getCustomer();
        Mockito.verify(customerServices).getCustomer();
    }

    @Test
    public void callCustomerService_getCustomerById(){
        String id = "someId";
        customerController.getCustomerById(id);
        Mockito.verify(customerServices).getCustomerById(Mockito.eq(id));
    }
}