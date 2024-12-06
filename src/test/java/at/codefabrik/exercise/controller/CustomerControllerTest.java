package at.codefabrik.exercise.controller;

import at.codefabrik.exercise.controller.CustomerController;
import at.codefabrik.exercise.model.Customer;
import at.codefabrik.exercise.services.CustomerServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerServices customerServices;

    @Test
    public void testGetCustomer() throws Exception {
        // Mock-Daten
        List<Customer> mockCustomers = Arrays.asList(
                new Customer("1L", "John Doe", "john@example.com"),
                new Customer("2L", "Jane Doe", "jane@example.com")
        );

        // Mock-Verhalten des Services
        Mockito.when(customerServices.getCustomer()).thenReturn(mockCustomers);

        // API-Aufruf und Validierung
        mockMvc.perform(MockMvcRequestBuilders.get("/customers") // URL anpassen
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(mockCustomers.size()))
                .andExpect(jsonPath("$[0].id").value("1L"))
                .andExpect(jsonPath("$[0].firstname").value("John Doe"))
                .andExpect(jsonPath("$[0].lastname").value("john@example.com"))
                .andExpect(jsonPath("$[1].id").value("2L"))
                .andExpect(jsonPath("$[1].firstname").value("Jane Doe"))
                .andExpect(jsonPath("$[1].lastname").value("jane@example.com"));

        // Verifizierung, dass der Service aufgerufen wurde
        Mockito.verify(customerServices, Mockito.times(1)).getCustomer();
    }
}