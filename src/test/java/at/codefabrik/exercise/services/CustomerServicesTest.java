package at.codefabrik.exercise.services;
import at.codefabrik.exercise.controller.CustomerController;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
class CustomerServicesTest {
    private CustomerServices customerServices;
    private CustomerController customerController;

    @BeforeEach
    public void setUp(){
        customerServices = Mockito.mock(CustomerServices.class);
        customerController = new CustomerController(customerServices);
    }
}
