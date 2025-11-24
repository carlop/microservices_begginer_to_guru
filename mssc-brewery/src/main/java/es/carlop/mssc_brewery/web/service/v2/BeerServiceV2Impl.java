package es.carlop.mssc_brewery.web.service.v2;

import es.carlop.mssc_brewery.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder()
                .id(beerId)
                .beerName(String.format("Beer %s", beerId.toString()))
                .beerStyle(String.format("Style %s", beerId))
                .upc(1000L)
                .build();
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName(beerDTO.beerName())
                .beerStyle(beerDTO.beerStyle())
                .upc(beerDTO.upc())
                .build();
    }

    @Override
    public void updateBeer(UUID beer, BeerDTO beerDTO) {
        log.debug("Updating beer with id: {}. New data: {}", beer, beerDTO);
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting beer with id: {}", beerId);
    }

}
