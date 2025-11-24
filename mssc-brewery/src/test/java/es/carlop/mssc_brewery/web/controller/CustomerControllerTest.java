package es.carlop.mssc_brewery.web.controller;

import es.carlop.mssc_brewery.web.model.CustomerDTO;
import es.carlop.mssc_brewery.web.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerTest {

    @Test
    void getCustomerById_ReturnsCustomerJson() throws Exception {
        UUID id = UUID.randomUUID();
        CustomerDTO dto = new CustomerDTO(id, "Customer-" + id);

        CustomerService customerService = Mockito.mock(CustomerService.class);
        when(customerService.getCustomerById(id)).thenReturn(dto);

        CustomerController controller = new CustomerController(customerService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/v1/customer/{customerId}", id.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.name").value("Customer-" + id));
    }

    @Test
    void getCustomerById_InvalidUUID_ReturnsBadRequest() throws Exception {
        CustomerService customerService = Mockito.mock(CustomerService.class);
        CustomerController controller = new CustomerController(customerService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/v1/customer/{customerId}", "not-a-uuid"))
                .andExpect(status().isBadRequest());
    }
}

