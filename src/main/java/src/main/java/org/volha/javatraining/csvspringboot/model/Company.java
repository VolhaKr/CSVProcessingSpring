package src.main.java.org.volha.javatraining.csvspringboot.model;


import org.springframework.stereotype.Component;

@Component
public class Company {
    private String companyName;
    private String companyCountry;
    private int companyCountryID;
    private int companyID;

    public Company() {
    }

    public Company(String companyName, String companyCountry) {
        this.companyName = companyName;
        this.companyCountry = companyCountry;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    public void setCompanyCountry(String companyCountry) {
        this.companyCountry = companyCountry;
    }
}




