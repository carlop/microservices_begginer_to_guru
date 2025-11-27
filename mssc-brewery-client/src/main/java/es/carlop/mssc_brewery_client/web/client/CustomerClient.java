package es.carlop.mssc_brewery_client.web.client;

import es.carlop.mssc_brewery_client.web.model.CustomerDTO;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreInvalidFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH_1 = "/api/v1/customer";
    @Setter
    private String apiHost;
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDTO getCustomerById(java.util.UUID id) {
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_1 + "/" + id.toString(), CustomerDTO.class);
    }

    public URI saveNewCustomer(CustomerDTO customerDTO) {
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_1, customerDTO);
    }

    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        restTemplate.put(apiHost + CUSTOMER_PATH_1 + "/" + customerId.toString(), customerDTO);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_1 + "/" + customerId.toString());
    }
}
