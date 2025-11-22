package es.carlop.mssc_brewery.web.service;

import es.carlop.mssc_brewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID customerId);
}
