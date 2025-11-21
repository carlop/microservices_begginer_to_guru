package es.carlop.mssc_brewery.web.controller;

import es.carlop.mssc_brewery.web.model.BeerDTO;
import es.carlop.mssc_brewery.web.service.BeerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId) {
        return ResponseEntity.ok(beerService.getBeerById(beerId));
    }

}
