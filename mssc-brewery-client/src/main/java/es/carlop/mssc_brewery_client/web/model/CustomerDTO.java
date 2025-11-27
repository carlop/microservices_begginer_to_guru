package es.carlop.mssc_brewery_client.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CustomerDTO(
        @JsonProperty("id") UUID id,
        @JsonProperty("name") String name
) { }
