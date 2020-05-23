package src.main.java.org.volha.javatraining.csvspringboot;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@ComponentScan()
@MappedTypes( {Country.class, Company.class})
@MapperScan("src.main.java.org.volha.javatraining.csvspringboot.mapper")
@SpringBootApplication
public class CSVSpringApp {

    public static void main(String[] args) {
        SpringApplication.run(CSVSpringApp.class, args);
    }

}