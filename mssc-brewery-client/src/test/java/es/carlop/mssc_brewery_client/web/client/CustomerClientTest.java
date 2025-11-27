package es.carlop.mssc_brewery_client.web.client;

import es.carlop.mssc_brewery_client.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDTO customerDTO = customerClient.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDTO);
    }

    @Test
    void testSaveNewCustomer() {
        //given
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("New Customer")
                .build();

        URI uri = customerClient.saveNewCustomer(customerDTO);

        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void testUpdateBeer() {
        //given
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("Updated Customer")
                .build();

        customerClient.updateCustomer(UUID.randomUUID(), customerDTO);
    }

    @Test
    void testDeleteBeer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }

}