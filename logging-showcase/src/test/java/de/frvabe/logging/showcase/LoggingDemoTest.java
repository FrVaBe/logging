package de.frvabe.logging.showcase;

import static org.awaitility.Awaitility.await;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

import de.frvabe.logging.showcase.LoggingDemo;

/**
 * Some assertion free logging tests. They are used to evaluate the logging output manually.
 */
public class LoggingDemoTest {

    @Test
    public void logOverSomeTime() throws InterruptedException {
        LoggingDemo.logSimpleString();
        LoggingDemo.logException();
        Instant wait = Instant.now().plusSeconds(5);
        await().atLeast(3, TimeUnit.SECONDS).until(() -> {
            return Instant.now().isAfter(wait);
        });
        LoggingDemo.logWithMappedDiagnosticContext();
        LoggingDemo.logWithMarker();
    }

    @Test
    public void logSimpleString() {
        LoggingDemo.logSimpleString();
    }

    @Test
    public void logException() {
        LoggingDemo.logException();
    }

    @Test
    public void logWithMappedDiagnosticContext() {
        LoggingDemo.logWithMappedDiagnosticContext();
    }

    @Test
    public void logWithMarker() {
        LoggingDemo.logWithMarker();
    }

}
