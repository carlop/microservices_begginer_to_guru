package es.carlop.mssc_brewery_client.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.UUID;

@Builder
public record BeerDTO(
        @JsonProperty("id") UUID id,
        @JsonProperty("beerName") String beerName,
        @JsonProperty("beerStyle") String beerStyle,
        @JsonProperty("upc") Long upc
) {
}
