package es.carlop.mssc_brewery.web.service;

import es.carlop.mssc_brewery.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder()
                .id(beerId)
                .beerName(String.format("Beer %s", beerId.toString()))
                .beerStyle(String.format("Style %s", beerId))
                .upc(1000L)
                .build();
    }
}
