# Logging Showcase

### About
This is a simple showcase on how to use logging. In this case it includes
* [SLF4J](https://www.slf4j.org/) as logging facade
* [Log4j 2](https://logging.apache.org/log4j/2.x/) as logging backend
* [Spring Boot](https://docs.spring.io/spring-boot/docs/2.1.0.RELEASE/reference/htmlsingle/) as application framework

The showcase has some code to demonstrate the usage of the SLF4J API and some configurtaion 
for the Log4j 2 backend.

Content may depend and change as needed by the author ;-)

### Sample Application

The showcase is packaged as a sample SprintBoot Application. Use the [Main](src/main/java/de/frvabe/logging/showcase/Main.java) 
class to start the application.

Logs will be written to the console and to rolling files in the `target\logs\` directory.
