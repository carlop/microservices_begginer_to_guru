package es.carlop.mssc_brewery;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MsscBreweryApplicationUnitTest {

    @Test
    void testClassHasSpringBootApplicationAnnotation() {
        assertTrue(MsscBreweryApplication.class.isAnnotationPresent(SpringBootApplication.class),
                "MsscBreweryApplication should be annotated with @SpringBootApplication");
    }

    @Test
    void testMain_InvokesSpringApplicationRun() {
        try (MockedStatic<SpringApplication> mocked = Mockito.mockStatic(SpringApplication.class)) {
            ConfigurableApplicationContext ctx = Mockito.mock(ConfigurableApplicationContext.class);
            mocked.when(() -> SpringApplication.run(MsscBreweryApplication.class, new String[]{})).thenReturn(ctx);

            // Call main - should invoke SpringApplication.run but our static mock prevents starting the context
            MsscBreweryApplication.main(new String[]{});

            // Verify that SpringApplication.run was called with the application class and any String[]
            mocked.verify(() -> SpringApplication.run(MsscBreweryApplication.class, new String[]{}));
        }
    }
}
