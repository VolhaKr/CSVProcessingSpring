package src.main.java.org.volha.javatraining.csvspringboot;

public class CsvReadRequest {
        private String filelocation;
    private String inputfilename;
    private String outpufilename;

    public CsvReadRequest(String filelocation, String inputfilename, String outputfilename) {

        this.filelocation = filelocation;
        this.inputfilename = inputfilename;
        this.outpufilename = outputfilename;
    }


    public String getFileLocation() {
        return filelocation;
    }

    public void setFileLocation(String filelocation) {
        this.filelocation = filelocation;
    }


    public String getInputfilename() {
        return inputfilename;
    }

    public void setInputfilename(String filename) {
        this.inputfilename = filename;
    }

    public String getOutpufilename() {
        return outpufilename;
    }

    public void setOutpufilename(String outpufilename) {
        this.outpufilename = outpufilename;
    }
}


