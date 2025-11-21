package es.carlop.mssc_brewery.web.service;

import es.carlop.mssc_brewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);
}
