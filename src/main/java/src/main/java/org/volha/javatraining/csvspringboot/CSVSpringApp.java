package src.main.java.org.volha.javatraining.csvspringboot;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import src.main.java.org.volha.javatraining.csvspringboot.model.Resident;


@ComponentScan()
@MappedTypes( {Country.class, Company.class, Resident.class})
@MapperScan("src.main.java.org.volha.javatraining.csvspringboot.mappers")
@SpringBootApplication
public class CSVSpringApp {

    public static void main(String[] args) {
        SpringApplication.run(CSVSpringApp.class, args);
    }

}