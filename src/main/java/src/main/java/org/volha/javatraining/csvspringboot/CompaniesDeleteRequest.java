package src.main.java.org.volha.javatraining.csvspringboot;

public class CompaniesDeleteRequest {
    private String companiesdeletefilelocation;
    private String companiesdeletefilename;

    public CompaniesDeleteRequest(String companiesdeletefilelocation, String companiesdeletefilename) {
        this.companiesdeletefilelocation = companiesdeletefilelocation;
        this.companiesdeletefilename = companiesdeletefilename;
    }

    public String getCompaniesdeletefilelocation() {
        return companiesdeletefilelocation;
    }

    public void setCompaniesdeletefilelocation(String companiesdeletefilelocation) {
        this.companiesdeletefilelocation = companiesdeletefilelocation;
    }

    public String getCompaniesdeletefilename() {
        return companiesdeletefilename;
    }

    public void setCompaniesdeletefilename(String companiesdeletefilename) {
        this.companiesdeletefilename = companiesdeletefilename;
    }
}
