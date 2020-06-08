package src.main.java.org.volha.javatraining.csvspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.CompanyCountryMapper;
import src.main.java.org.volha.javatraining.csvspringboot.model.Company;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.CompanyResidentMapper;
import src.main.java.org.volha.javatraining.csvspringboot.model.CompanyResident;
import src.main.java.org.volha.javatraining.csvspringboot.resource.CSVReadRequest;
import src.main.java.org.volha.javatraining.csvspringboot.services.DatabaseCompanyService;

import java.util.List;


@RestController
@RequestMapping("/database_companies")
public class DatabaseCompanyController {

    private CompanyResidentMapper companyResidentMapper;
    private CompanyCountryMapper companyCountryMapper;
    private final DatabaseCompanyService databaseCompanyService;

    @Autowired
    public DatabaseCompanyController(CompanyResidentMapper companyResidentMapper, CompanyCountryMapper companyCountryMapper, DatabaseCompanyService databaseCompanyService) {
        this.companyResidentMapper = companyResidentMapper;
        this.companyCountryMapper = companyCountryMapper;
        this.databaseCompanyService = databaseCompanyService;
    }

    @GetMapping("/all")
    public List<CompanyResident> getAllResidents() {
        return companyResidentMapper.findAllCompaniesResidents();
    }

    @GetMapping(path = "/all/{countryname}")
    public List<CompanyResident> getAllResidentsOfCountry(@PathVariable("countryname") String countryName) {
        return companyResidentMapper.findAllCompaniesResidentsFromSpecificCountry(countryName);
    }

//    @GetMapping("/update")
//    private List<Company> update() {
//        int fk = 1000;
//        Company company = new Company();
//        company.setCompanyName("Added Company");
//        company.setCompanyCountry("ENGLAND");
//        companyResidentMapper.insertCompany("Added Company", fk);
//        return companyResidentMapper.findAllCompaniesResidents();
//    }

//    @RequestMapping(method = RequestMethod.PUT, value = "/update/{companyname}")
//    public List<CompanyResident> updateCompany(@RequestBody Company companyNew, @PathVariable("companyname") String companyToUpdateName) {
//        if ((!(companyNew == null)) & (!(companyNew.getCompanyName() == null)) ) {
//            String companyNewName = companyNew.getCompanyName();
//            String companyNewCountry = companyNew.getCompanyCountry();
//            List <CompanyResident> matchingCompanies = companyResidentMapper.selectSpecificCompany(companyNewName, companyNewCountry);
//            if (!matchingCompanies.isEmpty()) {
//    System.out.println("updating...");
//                // if (!(companyResidentMapper.selectSpecificCompany (companyName, companyCountry).isEmpty())
//                List<String> matchingCountries = companyCountryMapper.getCountry(companyNewCountry);
//                System.out.println(matchingCountries);
//                if (matchingCountries.isEmpty()) {
//                    companyCountryMapper.insertCompanyCountryIfNotExists(companyNewCountry);
//                }
//                int companyCountryFK = companyCountryMapper.getCompanyCountryFK(companyNewCountry);
//                companyResidentMapper.updateCompany(companyToUpdateName, companyNew.getCompanyName(), companyCountryFK);
//
//            } else {
//                System.out.println("Such company exists in the database");
//            }
//        }
//        return companyResidentMapper.findAllCompaniesResidents();
//    }


//        @PostMapping ("/add-company/")
//public List<CompanyResident> insertCompany(String companyName, String companyCountry) {
//        List<String> matchingCountries = companyCountryMapper.getCountry(companyCountry);
//          if (matchingCountries.isEmpty()){
//              companyCountryMapper.insertCompanyCountryIfNotExists(companyCountry);
//          }
//            return companyResidentMapper.findAllCompaniesResidents();
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public List<CompanyResident> insertCompany(@RequestBody Company company) {
        databaseCompanyService.insertCompanyIntoDB(company);
        return companyResidentMapper.findAllCompaniesResidents();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/add-from-csv")
    public List<CompanyResident> addCompaniesFromCSV(@RequestBody CSVReadRequest csvReadRequest) {
        databaseCompanyService.insertCSVCompaniesIntoDB(csvReadRequest);
        return companyResidentMapper.findAllCompaniesResidents();
    }
//        //?? could be replaced with !(company.getCompanyName() == null)
//        if ((!(company == null)) & (!(company.getCompanyName() == null)) ) {
//            String companyName = company.getCompanyName();
//            String companyCountry = company.getCompanyCountry();
//            if (!(companyResidentMapper.checkIfCompanyExists(companyName, companyCountry))) {
////    System.out.println("YES");
//                // if (!(companyResidentMapper.selectSpecificCompany (companyName, companyCountry).isEmpty())
//                List<String> matchingCountries = companyCountryMapper.getCountry(companyCountry);
//                System.out.println(matchingCountries);
//                if (matchingCountries.isEmpty()) {
//                    companyCountryMapper.insertCompanyCountryIfNotExists(companyCountry);
//                }
//                int companyCountryFK = companyCountryMapper.getCompanyCountryFK(companyCountry);
//                companyResidentMapper.insertCompany(company.getCompanyName(), companyCountryFK);
//
//            } else {
//                System.out.println("Such company exists in the database");
//            }
//        }
//        return companyResidentMapper.findAllCompaniesResidents();
    //   }

////////////////

    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public List<CompanyResident> deleteCompanyFromDatabase(@RequestBody Company company) {
        databaseCompanyService.deleteCompanyFromDB(company);
        return companyResidentMapper.findAllCompaniesResidents();
    }


//public List<CompanyResident> deleteCompany(@RequestBody Company company) {
//    //?? could be replaced with !(company.getCompanyName() == null)
//    if ((!(company == null)) & (!(company.getCompanyName() == null)) ) {
//        String companyName = company.getCompanyName();
//        String companyCountry = company.getCompanyCountry();
//        List<CompanyResident> matchingCompanies = companyResidentMapper.selectSpecificCompany(companyName, companyCountry);
//        if (!(matchingCompanies.isEmpty())) {
//                System.out.println("Deleting");
//              companyResidentMapper.deleteCompany(companyName, companyCountry);
//
//        } else {
//            System.out.println("Such company exists in the database");
//        }
//    }
//    return companyResidentMapper.findAllCompaniesResidents();
//}
}



