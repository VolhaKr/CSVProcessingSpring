package src.main.java.org.volha.javatraining.csvspringboot.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.org.volha.javatraining.csvspringboot.Company;
import src.main.java.org.volha.javatraining.csvspringboot.CompanyService;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.CompanyCountryMapper;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.ResidentMapper;
import src.main.java.org.volha.javatraining.csvspringboot.model.Resident;

import java.util.List;
@RestController
@RequestMapping("/residents")
public class ResidentResource {

        private ResidentMapper residentMapper;

        @Autowired
        public ResidentResource (ResidentMapper residentMapper){
            this.residentMapper = residentMapper;
        }

        @GetMapping("/all")
        public List<Resident> getAllResidents(){
            return residentMapper.findAllResidents();
        }


}
