package src.main.java.org.volha.javatraining.csvspringboot;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        ///it is necessary to add condition that the company is not null, but the country is not ""ENGLAND
//        assertTrue((companyService.getCompany("ABC").equals(null))||
//                ((!(companyService.getCompany("ABC").equals(null)))&
//                        (!(companyService.getCompany("ABC").getCompanyCountry().equals(null)))));
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
    public void deleteExistingCompanyReturnTrue() throws Exception {
        CompanyService companyService = getCompanyService("ABC", "ENGLAND");
        assertTrue(companyService.deleteCompany("ABC", "ENGLAND"));
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