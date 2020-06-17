package src.main.java.org.volha.javatraining.csvspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.CompanyCountryMapper;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.CompanyMapper;
import src.main.java.org.volha.javatraining.csvspringboot.model.Company;
import src.main.java.org.volha.javatraining.csvspringboot.model.CompanyResident;
import src.main.java.org.volha.javatraining.csvspringboot.resource.CSVReadRequest;
import src.main.java.org.volha.javatraining.csvspringboot.services.DatabaseCompanyService;

import java.util.List;

@RestController
@RequestMapping("/database_companies")
public class DatabaseCompanyController {

    private CompanyMapper companyMapper;
    private CompanyCountryMapper companyCountryMapper;
    private final DatabaseCompanyService databaseCompanyService;

    @Autowired
    public DatabaseCompanyController(CompanyMapper companyMapper, CompanyCountryMapper companyCountryMapper, DatabaseCompanyService databaseCompanyService) {
        this.companyMapper = companyMapper;
        this.companyCountryMapper = companyCountryMapper;
        this.databaseCompanyService = databaseCompanyService;
    }

    @GetMapping("/all")
    public List<CompanyResident> getAllResidents() {
        return companyMapper.findAllCompaniesResidents();
    }

    @GetMapping(path = "/all/{countryname}")
    public List<CompanyResident> getAllResidentsOfCountry(@PathVariable("countryname") String countryName) {
        return companyMapper.findAllCompaniesResidentsFromSpecificCountry(countryName);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public List<CompanyResident> insertCompany(@RequestBody Company company) {
        databaseCompanyService.insertCompanyIntoDB(company);
        return companyMapper.findAllCompaniesResidents();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/add-from-csv")
    public List<CompanyResident> addCompaniesFromCSV(@RequestBody CSVReadRequest csvReadRequest) {
        databaseCompanyService.insertCSVCompaniesIntoDB(csvReadRequest);
        return companyMapper.findAllCompaniesResidents();
    }
//        //?? could be replaced with !(company.getCompanyName() == null)
//        if ((!(company == null)) & (!(company.getCompanyName() == null)) ) {
//            String companyName = company.getCompanyName();
//            String companyCountry = company.getCompanyCountry();
//            if (!(companyMapper.checkIfCompanyExists(companyName, companyCountry))) {
////    System.out.println("YES");
//                // if (!(companyMapper.selectSpecificCompany (companyName, companyCountry).isEmpty())
//                List<String> matchingCountries = companyCountryMapper.getCountry(companyCountry);
//                System.out.println(matchingCountries);
//                if (matchingCountries.isEmpty()) {
//                    companyCountryMapper.insertCompanyCountryIfNotExists(companyCountry);
//                }
//                int companyCountryFK = companyCountryMapper.getCompanyCountryFK(companyCountry);
//                companyMapper.insertCompany(company.getCompanyName(), companyCountryFK);
//
//            } else {
//                System.out.println("Such company exists in the database");
//            }
//        }
//        return companyMapper.findAllCompaniesResidents();
    //   }

////////////////

    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public List<CompanyResident> deleteCompanyFromDatabase(@RequestBody Company company) {
        databaseCompanyService.deleteCompanyFromDB(company);
        return companyMapper.findAllCompaniesResidents();
    }


//public List<CompanyResident> deleteCompany(@RequestBody Company company) {
//    //?? could be replaced with !(company.getCompanyName() == null)
//    if ((!(company == null)) & (!(company.getCompanyName() == null)) ) {
//        String companyName = company.getCompanyName();
//        String companyCountry = company.getCompanyCountry();
//        List<CompanyResident> matchingCompanies = companyMapper.selectSpecificCompany(companyName, companyCountry);
//        if (!(matchingCompanies.isEmpty())) {
//                System.out.println("Deleting");
//              companyMapper.deleteCompany(companyName, companyCountry);
//
//        } else {
//            System.out.println("Such company exists in the database");
//        }
//    }
//    return companyMapper.findAllCompaniesResidents();
//}
}



