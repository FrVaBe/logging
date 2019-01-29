package de.frvabe.logging.showcase;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Main class to execute an endless running logging sample which will generate some logging output
 * every fixed rate..
 */
@SpringBootApplication
@EnableScheduling
@Component
public class Main {

    static {
        System.setProperty("logging.config",
                System.getProperty("user.dir") + "/src/test/resources/log4j2.xml");
    }

    /**
     * Main class to start the application.
     * 
     * @param args application arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * Does some random logging every fixed rate.
     */
    @Scheduled(fixedRate = 100)
    public void doLog() {
        switch (new Random().nextInt(4)) {
            case 1:
                LoggingDemo.logException();
                break;
            case 2:
                LoggingDemo.logWithMappedDiagnosticContext();
                break;
            case 3:
                LoggingDemo.logWithMarker();
                break;
            default:
                LoggingDemo.logSimpleString();
        }
    }

}
