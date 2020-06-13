package src.main.java.org.volha.javatraining.csvspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.CompanyCountryMapper;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.CompanyMapper;
import src.main.java.org.volha.javatraining.csvspringboot.model.Company;
import src.main.java.org.volha.javatraining.csvspringboot.model.CompanyResident;
import src.main.java.org.volha.javatraining.csvspringboot.resource.CSVReadRequest;

import java.util.List;

@Service
public class DatabaseCompanyService {

    private final CompanyCountryMapper companyCountryMapper;
    private CompanyMapper companyMapper;

    @Autowired
    public DatabaseCompanyService(CompanyMapper companyMapper, CompanyCountryMapper companyCountryMapper) {
        this.companyMapper = companyMapper;
        this.companyCountryMapper = companyCountryMapper;
    }

    // public List<CompanyResident> insertCompany(@RequestBody Company company) {
    public void insertCompanyIntoDB(Company company) {
        //?? could be replaced with !(company.getCompanyName() == null)
        if ((!(company == null)) & (!(company.getCompanyName() == null))) {
            String companyName = company.getCompanyName();
            String companyCountry = company.getCompanyCountry();
            if (!(companyMapper.checkIfCompanyExists(companyName, companyCountry))) {
//    System.out.println("YES");
                // if (!(companyMapper.selectSpecificCompany (companyName, companyCountry).isEmpty())
                List<String> matchingCountries = companyCountryMapper.getCountry(companyCountry);
                System.out.println(matchingCountries);
                if (matchingCountries.isEmpty()) {
                    companyCountryMapper.insertCompanyCountryIfNotExists(companyCountry);
                }
                int companyCountryFK = companyCountryMapper.getCompanyCountryFK(companyCountry);
                companyMapper.insertCompany(company.getCompanyName(), companyCountryFK);

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
            List<CompanyResident> matchingCompanies = companyMapper.selectSpecificCompany(companyName, companyCountry);
                        if (!(matchingCompanies.isEmpty())) {
                System.out.println("Deleting");
                companyMapper.deleteCompany(companyName, companyCountry);

            } else {
                System.out.println("Such company doesn't exist in the database");
            }
//            List <Integer> tempToTest = companyMapper.selectSpecificCompanyID(companyName, companyCountry);
//            if (!(tempToTest.isEmpty())) {
//                for (int t:tempToTest) {
//                    System.out.println("Deleting");
//                    companyMapper.deleteCompanyByID(t);
//                }
//            } else {
//                System.out.println("Such company exists in the database");
//            }
//            if (!(matchingCompanies.isEmpty())) {
//                System.out.println("Deleting");
//                companyMapper.deleteCompany(companyName, companyCountry);
//
//            } else {
//                System.out.println("Such company exists in the database");
//            }
        }

    }

    public void insertCSVCompaniesIntoDB(CSVReadRequest csvReadRequest) {
    }
}
