package es.carlop.mssc_brewery.web.model.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.UUID;

@Builder
public record BeerDTOV2(
        @JsonProperty("id") UUID id,
        @JsonProperty("beerName") String beerName,
        @JsonProperty("beerStyle") BeerStyle beerStyle,
        @JsonProperty("upc") Long upc
) {

}
