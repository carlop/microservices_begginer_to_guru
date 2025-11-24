package es.carlop.mssc_brewery.web.controller;

import es.carlop.mssc_brewery.web.model.BeerDTO;
import es.carlop.mssc_brewery.web.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Deprecated
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

    @PostMapping
    public ResponseEntity<BeerDTO> saveBeer(@RequestBody BeerDTO beerDTO) {
        BeerDTO savedDTO = beerService.saveNewBeer(beerDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + savedDTO.id().toString());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{beerId}")
                .build(savedDTO.id());


        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDTO> updateBeer(@PathVariable("beerId") UUID beer, BeerDTO beerDTO) {
        beerService.updateBeer(beer, beerDTO);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteById(beerId);
    }

}
