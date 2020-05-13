package src.main.java.org.volha.javatraining.csvspringboot;

public class CSVResult {


    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CSVResult() {
    }

}

