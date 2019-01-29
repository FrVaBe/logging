package de.frvabe.logging.showcase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Main class to demonstrate different Logging API usages.
 */
public final class LoggingDemo {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingDemo.class);

    private LoggingDemo() {
        // hide constructor
    }

    static void logSimpleString() {
        LOGGER.debug("Hello World!");
    }

    static void logException() {
        Exception ex = new RuntimeException("Execption that was generated for test purpose.");
        LOGGER.debug("An exception occured!", ex);
    }

    static void logWithMappedDiagnosticContext() {

        // put some information in the context map
        MDC.put("foo", "bar");
        MDC.put("lorem", "ipsum");
 
        // this log event will be stamped with the MDC
        LOGGER.debug("A message with MDC.");
 
        new Thread(() -> {
            // this log event will not be stamped with the MDC
            // because it belongs to another thread
            LOGGER.debug("A message in another thread!");
        }).start();
 
        MDC.clear();

    }

    static void logWithMarker() {

        // create some marker
        // (consider to use static constants to generate markers that are fixed at compile time)
        Marker roadMarker = MarkerFactory.getMarker("A0815");
        Marker aq4711Marker = MarkerFactory.getMarker("AQ4711");
        Marker aq4712Marker = MarkerFactory.getMarker("AQ4712");

        // join the marker by adding references to each other (in fact you add a 'parent' reference)
        aq4711Marker.add(roadMarker);
        aq4712Marker.add(roadMarker);

        // use the marker in logging statements
        LOGGER.debug(aq4711Marker, "Something happens...");
        LOGGER.debug(aq4712Marker, "Something happens...");

    }

}
