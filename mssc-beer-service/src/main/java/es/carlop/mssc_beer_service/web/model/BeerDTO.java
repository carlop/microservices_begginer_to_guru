package es.carlop.mssc_beer_service.web.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
public record BeerDTO(
        UUID id,
        Integer version,
        OffsetDateTime createdDate,
        OffsetDateTime lastModifiedDate,
        String beerName,
        BeerStyle beerStyle,
        Long upc,
        BigDecimal price,
        Integer quantityOnHand
) {
}
