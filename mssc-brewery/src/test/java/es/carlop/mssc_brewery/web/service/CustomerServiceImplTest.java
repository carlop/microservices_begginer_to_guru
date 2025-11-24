package es.carlop.mssc_brewery.web.service;

import es.carlop.mssc_brewery.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {

    @Test
    void getCustomerByIdReturnsCustomerWithNameContainingId() {
        CustomerServiceImpl service = new CustomerServiceImpl();
        UUID id = UUID.randomUUID();

        CustomerDTO dto = service.getCustomerById(id);

        assertNotNull(dto);
        assertNotNull(dto.id());
        assertTrue(dto.name().contains(id.toString()));
    }

    @Test
    void getCustomerByIdNullIdThrowsNPE() {
        CustomerServiceImpl service = new CustomerServiceImpl();

        assertThrows(NullPointerException.class, () -> service.getCustomerById(null));
    }
}

