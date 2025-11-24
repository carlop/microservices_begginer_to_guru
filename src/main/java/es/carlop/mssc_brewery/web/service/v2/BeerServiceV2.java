package es.carlop.mssc_brewery.web.service.v2;

import es.carlop.mssc_brewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    void updateBeer(UUID beer, BeerDTO beerDTO);

    void deleteById(UUID beerId);
}
