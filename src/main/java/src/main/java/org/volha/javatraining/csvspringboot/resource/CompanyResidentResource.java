package src.main.java.org.volha.javatraining.csvspringboot.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.CompanyResidentMapper;
import src.main.java.org.volha.javatraining.csvspringboot.model.CompanyResident;

import java.util.List;

@RestController
@RequestMapping("/companies_residents")
public class CompanyResidentResource {

      private CompanyResidentMapper companyResidentMapper;

        @Autowired
        public CompanyResidentResource (CompanyResidentMapper companyResidentMapper){
            this.companyResidentMapper = companyResidentMapper;
        }

        @GetMapping("/all")
        public List<CompanyResident> getAllResidents(){
            return companyResidentMapper.findAllCompaniesResidents();
        }


    }

