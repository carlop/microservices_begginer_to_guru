package es.carlop.mssc_brewery.web.controller;

import es.carlop.mssc_brewery.web.model.BeerDTO;
import es.carlop.mssc_brewery.web.service.BeerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BeerControllerTest {

    @Test
    void getBeerById_ReturnsBeerJson() throws Exception {
        UUID id = UUID.randomUUID();
        BeerDTO dto = BeerDTO.builder()
                .id(id)
                .beerName("MyBeer")
                .beerStyle("IPA")
                .upc(123L)
                .build();

        BeerService beerService = Mockito.mock(BeerService.class);
        when(beerService.getBeerById(id)).thenReturn(dto);

        BeerController controller = new BeerController(beerService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/v1/beer/{beerId}", id.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.beerName").value("MyBeer"))
                .andExpect(jsonPath("$.beerStyle").value("IPA"))
                .andExpect(jsonPath("$.upc").value(123));
    }

    @Test
    void getBeerById_InvalidUUID_ReturnsBadRequest() throws Exception {
        BeerService beerService = Mockito.mock(BeerService.class);
        BeerController controller = new BeerController(beerService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/v1/beer/{beerId}", "not-a-uuid"))
                .andExpect(status().isBadRequest());
    }
}
