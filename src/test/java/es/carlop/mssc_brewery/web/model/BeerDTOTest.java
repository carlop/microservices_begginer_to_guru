package es.carlop.mssc_brewery.web.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BeerDTOTest {

    @Test
    void testRecordAccessorsAndEquality() {
        UUID id = UUID.randomUUID();
        BeerDTO beer1 = new BeerDTO(id, "MyBeer", "LAGER", 999L);
        BeerDTO beer2 = new BeerDTO(id, "MyBeer", "LAGER", 999L);

        // Accessors
        assertEquals(id, beer1.id());
        assertEquals("MyBeer", beer1.beerName());
        assertEquals("LAGER", beer1.beerStyle());
        assertEquals(999L, beer1.upc());

        // Equality and hashCode
        assertEquals(beer1, beer2);
        assertEquals(beer1.hashCode(), beer2.hashCode());

        // toString contains component values
        String s = beer1.toString();
        assertTrue(s.contains("MyBeer"));
        assertTrue(s.contains("LAGER"));
        assertTrue(s.contains("999"));
    }
}

