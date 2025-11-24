package es.carlop.mssc_brewery.web.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDTOTest {

    @Test
    void recordAccessorsAndEquality() {
        UUID id = UUID.randomUUID();
        CustomerDTO c1 = new CustomerDTO(id, "Alice");
        CustomerDTO c2 = new CustomerDTO(id, "Alice");

        assertEquals(id, c1.id());
        assertEquals("Alice", c1.name());

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());

        String s = c1.toString();
        assertTrue(s.contains("Alice"));
        assertTrue(s.contains(id.toString()));
    }

    @Test
    void handlesNullNameAndIdEqualityAndToString() {
        CustomerDTO cNulls1 = new CustomerDTO(null, null);
        CustomerDTO cNulls2 = new CustomerDTO(null, null);

        assertNull(cNulls1.id());
        assertNull(cNulls1.name());

        assertEquals(cNulls1, cNulls2);
        assertEquals(cNulls1.hashCode(), cNulls2.hashCode());

        String s = cNulls1.toString();
        assertTrue(s.contains("null"));
    }

    @Test
    void inequalityWhenDifferentValues() {
        CustomerDTO c1 = new CustomerDTO(UUID.randomUUID(), "Bob");
        CustomerDTO c2 = new CustomerDTO(UUID.randomUUID(), "Bob");
        CustomerDTO c3 = new CustomerDTO(c1.id(), "Charlie");

        assertNotEquals(c1, c2);
        assertNotEquals(c1, c3);
    }
}

