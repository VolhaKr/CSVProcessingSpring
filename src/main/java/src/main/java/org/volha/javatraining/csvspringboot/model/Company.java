package src.main.java.org.volha.javatraining.csvspringboot.model;

import org.springframework.stereotype.Component;

public class Company {
    private int companyID;
    private String companyName;
    private String companyCountry;

    public Company() {
    }

    public Company(int companyID) {
        this.companyID = companyID;
    }

    public Company(int companyID, String companyName, String companyCountry) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.companyCountry = getCountry(companyCountry);
    }

    public Company(String companyName, String companyCountry) {
        this.companyName = companyName;
        this.companyCountry = getCountry(companyCountry);
    }

    private String getCountry (String countryName){
        if (countryName==null){
            return Country.NONE.name();
        }
        return countryName;
    }
    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
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




