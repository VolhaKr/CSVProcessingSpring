package src.main.java.org.volha.javatraining.csvspringboot;

public class CSVReadRequest {
    private String fileLocation;
    private String inputFileName;
    private String outputFileName;

    public CSVReadRequest(String fileLocation, String inputFileName, String outputFileName) {
        this.fileLocation = fileLocation;
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }
}

