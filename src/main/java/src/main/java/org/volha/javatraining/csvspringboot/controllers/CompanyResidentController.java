package src.main.java.org.volha.javatraining.csvspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.org.volha.javatraining.csvspringboot.model.Company;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.CompanyResidentMapper;
import src.main.java.org.volha.javatraining.csvspringboot.model.CompanyResident;

import java.util.List;

@RestController
@RequestMapping("/companies_residents")
public class CompanyResidentController {

      private CompanyResidentMapper companyResidentMapper;

        @Autowired
        public CompanyResidentController(CompanyResidentMapper companyResidentMapper){
            this.companyResidentMapper = companyResidentMapper;
        }

        @GetMapping("/all")
        public List<CompanyResident> getAllResidents(){
            return companyResidentMapper.findAllCompaniesResidents();
        }


//        @GetMapping(path = "/all/{countryname}")
//    public Company getResident(@PathVariable("countryname") String countryName) {
//        return companyResidentMapper.findCountryResidents(countryName);
//    }
 @GetMapping ("/update")
    private List<CompanyResident> update(){
            Company company = new Company();;
            company.setCompanyName("Added Company");
            company.setCompanyCountry("ENGLAND");
 companyResidentMapper.insert(company);
 return companyResidentMapper.findAllCompaniesResidents();
        }

    }

