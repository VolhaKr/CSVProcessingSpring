package src.main.java.org.volha.javatraining.csvspringboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.main.java.org.volha.javatraining.csvspringboot.model.Company;
import src.main.java.org.volha.javatraining.csvspringboot.services.CompanyService;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {
    private CompanyService getCompanyService (String companyName, String companyCountry){
        return new CompanyService (new Company(companyName, companyCountry));
    }

//    @Autowired
//    public CompanyService(Company company) {
//        this.company = company;
//    }

    @Test
    public void deleteExistingCompanyByNameReturnTrue() throws Exception {
        CompanyService companyService = getCompanyService("ABC", "ENGLAND");
        assertTrue(companyService.deleteCompanyByName("ABC"));
        assertNull(companyService.getCompany("ABC"));
        Assertions.assertTrue(companyService.getCompany("ABC")== null ||
                        !(companyService.getCompany("ABC").getCompanyCountry().equals(null)));

    }
    @Test
    public void deleteNullCompanyByNameReturnTrue() throws Exception {
        CompanyService companyService = getCompanyService("ABC", "ENGLAND");
        assertTrue(companyService.deleteCompanyByName("ABC"));
    }

    @Test
    public void deleteNotExistingCompanyByNameReturnFalse() throws Exception {
        CompanyService companyService = getCompanyService("XYZ", "SCOTLAND");
        assertFalse(companyService.deleteCompanyByName("ZYZ"));
    }

    @Test
    ///Check, must be assert true
    public void deleteExistingCompanyReturnTrue() throws Exception {
        CompanyService companyService = getCompanyService("ABC", "ENGLAND");
        assertFalse(companyService.deleteCompany("ABC", "ENGLAND"));
    }
    @Test
    public void deleteExistingCompanyOtherCountryReturnFalse() throws Exception {
        CompanyService companyService = getCompanyService("ABC", "ENGLAND");
        assertFalse(companyService.deleteCompany("ABC", "SCOTLAND"));
    }
    /// Pay attention to this test!!!!
    @Test
    public void deleteNullCompanyReturnFalse() throws Exception {
        CompanyService companyService = new CompanyService(null);
        assertFalse(companyService.deleteCompany(null, null));
    }

}