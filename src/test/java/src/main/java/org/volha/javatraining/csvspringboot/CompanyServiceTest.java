package src.main.java.org.volha.javatraining.csvspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {

//    @Autowired
//    public CompanyService(Company company) {
//        this.company = company;
//    }

    @Test
    public void deleteExistingCompanyByNameReturnTrue() throws Exception {
        CompanyService companyService = new CompanyService(new Company("ABC", "ENGLAND"));
        assertTrue(companyService.deleteCompanyByName("ABC"));
    }
    @Test
    public void deleteNullCompanyByNameReturnTrue() throws Exception {
        CompanyService companyService = new CompanyService(new Company("ABC", "ENGLAND"));
        assertTrue(companyService.deleteCompanyByName("ABC"));
    }

    @Test
    public void deleteNotExistingCompanyByNameReturnFalse() throws Exception {
        CompanyService companyService = new CompanyService(new Company("XYZ", "SCOTLAND"));
        assertFalse(companyService.deleteCompanyByName("ZYZ"));
    }

    @Test
    public void deleteExistingCompanyReturnTrue() throws Exception {
        CompanyService companyService = new CompanyService(new Company("ABC", "ENGLAND"));
        assertTrue(companyService.deleteCompany("ABC", "ENGLAND"));
    }
    @Test
    public void deleteExistingCompanyOtherCountryReturnFalse() throws Exception {
        CompanyService companyService = new CompanyService(new Company("ABC", "ENGLAND"));
        assertFalse(companyService.deleteCompany("ABC", "SCOTLAND"));
    }
    /// Pay attention to this test!!!!
    @Test
    public void deleteNullCompanyReturnFalse() throws Exception {
        CompanyService companyService = new CompanyService(null);
        assertTrue(companyService.deleteCompany(null, null));
    }

}