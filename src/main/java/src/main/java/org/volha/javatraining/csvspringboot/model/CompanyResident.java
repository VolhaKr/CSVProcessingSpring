package src.main.java.org.volha.javatraining.csvspringboot.model;

public class CompanyResident {
    private int companyID;
    private String companyName;
    private String companyCountry;

    public CompanyResident(int companyID, String companyName, String companyCountry) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.companyCountry = companyCountry;
    }

    public CompanyResident(String companyName, String companyCountry) {
        this.companyName = companyName;
        this.companyCountry = companyCountry;
    }

    public CompanyResident(int companyID) {
        this.companyID = companyID;
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
