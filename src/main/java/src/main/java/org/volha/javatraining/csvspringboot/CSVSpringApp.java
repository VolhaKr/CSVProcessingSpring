package src.main.java.org.volha.javatraining.csvspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan()
@SpringBootApplication
public class CSVSpringApp {

    public static void main(String[] args) {
        SpringApplication.run(CSVSpringApp.class, args);
    }

}