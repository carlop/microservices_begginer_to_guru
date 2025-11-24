package es.carlop.mssc_brewery.web.service;

import es.carlop.mssc_brewery.web.model.BeerDTO;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BeerServiceImplTest {

    @Test
    void testGetBeerById_ReturnsExpectedBeerDTO() {
        BeerServiceImpl service = new BeerServiceImpl();
        UUID id = UUID.randomUUID();

        BeerDTO dto = service.getBeerById(id);

        assertNotNull(dto);
        assertEquals(id, dto.id());
        assertEquals(1000L, dto.upc());
        assertTrue(dto.beerName().contains(id.toString()));
        assertTrue(dto.beerStyle().contains(id.toString()));
    }

    @Test
    void testGetBeerById_NullId_ThrowsNPE() {
        BeerServiceImpl service = new BeerServiceImpl();

        assertThrows(NullPointerException.class, () -> service.getBeerById(null));
    }
}

