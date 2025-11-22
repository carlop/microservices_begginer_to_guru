package es.carlop.mssc_brewery.web.service;

import es.carlop.mssc_brewery.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name(String.format("Customer %s", customerId.toString()))
                .build();
    }
}
