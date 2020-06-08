package src.main.java.org.volha.javatraining.csvspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.CompanyCountryMapper;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.CompanyResidentMapper;
import src.main.java.org.volha.javatraining.csvspringboot.model.Company;
import src.main.java.org.volha.javatraining.csvspringboot.model.CompanyResident;
import src.main.java.org.volha.javatraining.csvspringboot.resource.CSVReadRequest;

import java.util.List;

@Service
public class DatabaseCompanyService {

    private final CompanyCountryMapper companyCountryMapper;
    private CompanyResidentMapper companyResidentMapper;

    @Autowired
    public DatabaseCompanyService(CompanyResidentMapper companyResidentMapper, CompanyCountryMapper companyCountryMapper) {
        this.companyResidentMapper = companyResidentMapper;
        this.companyCountryMapper = companyCountryMapper;
    }

    // public List<CompanyResident> insertCompany(@RequestBody Company company) {
    public void insertCompanyIntoDB(Company company) {
        //?? could be replaced with !(company.getCompanyName() == null)
        if ((!(company == null)) & (!(company.getCompanyName() == null))) {
            String companyName = company.getCompanyName();
            String companyCountry = company.getCompanyCountry();
            if (!(companyResidentMapper.checkIfCompanyExists(companyName, companyCountry))) {
//    System.out.println("YES");
                // if (!(companyResidentMapper.selectSpecificCompany (companyName, companyCountry).isEmpty())
                List<String> matchingCountries = companyCountryMapper.getCountry(companyCountry);
                System.out.println(matchingCountries);
                if (matchingCountries.isEmpty()) {
                    companyCountryMapper.insertCompanyCountryIfNotExists(companyCountry);
                }
                int companyCountryFK = companyCountryMapper.getCompanyCountryFK(companyCountry);
                companyResidentMapper.insertCompany(company.getCompanyName(), companyCountryFK);

            } else {
                System.out.println("Such company exists in the database");
            }
        }
    }


    public void deleteCompanyFromDB(Company company) {
        //?? could be replaced with !(company.getCompanyName() == null)
        if ((!(company == null)) & (!(company.getCompanyName() == null))) {
            String companyName = company.getCompanyName();
            String companyCountry = company.getCompanyCountry();
            List<CompanyResident> matchingCompanies = companyResidentMapper.selectSpecificCompany(companyName, companyCountry);
            if (!(matchingCompanies.isEmpty())) {
                System.out.println("Deleting");
                companyResidentMapper.deleteCompany(companyName, companyCountry);

            } else {
                System.out.println("Such company exists in the database");
            }
        }

    }

    public void insertCSVCompaniesIntoDB(CSVReadRequest csvReadRequest) {
    }
}
