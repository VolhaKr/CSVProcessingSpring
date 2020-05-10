package src.main.java.org.volha.javatraining.csvspringboot;

public class CSVCompaniesAddRequest {
    private String companiesaddfilelocation;
    private String companiesaddfilename;

    public CSVCompaniesAddRequest(String companiesaddfilelocation, String companiesaddfilename) {
        this.companiesaddfilelocation = companiesaddfilelocation;
        this.companiesaddfilename = companiesaddfilename;
    }

    public String getCompaniesaddfilelocation() {
        return companiesaddfilelocation;
    }

    public void setCompaniesaddfilelocation(String companiesaddfilelocation) {
        this.companiesaddfilelocation = companiesaddfilelocation;
    }

    public String getCompaniesaddfilename() {
        return companiesaddfilename;
    }

    public void setCompaniesaddfilename(String companiesaddfilename) {
        this.companiesaddfilename = companiesaddfilename;
    }
}