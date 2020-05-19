package src.main.java.org.volha.javatraining.csvspringboot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.SpringApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVReadServiceTest {
    private CSVReadService csvReadService;
    private CSVResult csvResult;
    private static final String DIRECTORY_PATH = "D:\\Java\\JavaTraining";
    private static final String INPUT_FILE = "data.csv";
    private static final String RESULT_FILE = "result.csv";

    @BeforeAll
    public void setup() {
        csvReadService = new CSVReadService();
        csvResult = new CSVResult();
    }

    @Test
    private void readExistingProcessFileReturnTrue() throws IOException {
        csvResult = csvReadService.readProcessFile(DIRECTORY_PATH, INPUT_FILE, RESULT_FILE);
        assertTrue(csvResult.isSuccess());
        List<String> inputFileStream = Files.readAllLines(Paths.get(INPUT_FILE));
        List<String> resultFileStream = Files.readAllLines(Paths.get(RESULT_FILE));
        assertEquals(inputFileStream.size(), resultFileStream.size());
    }

    @Test
    private void readNotExistingProcessFileReturnFalse() throws IOException {
        csvResult = csvReadService.readProcessFile(DIRECTORY_PATH, "data1.csv", RESULT_FILE);
        assertFalse(csvResult.isSuccess());
    }

    @Test
    private void readNullProcessFileReturnFalse() throws IOException {
        csvResult = csvReadService.readProcessFile(DIRECTORY_PATH, "data1.csv", RESULT_FILE);
        assertFalse(csvResult.isSuccess());
    }

    @Test
    private void readExistingProcessFileToNotExistingResultReturnFalse() throws IOException {
        csvResult = csvReadService.readProcessFile(DIRECTORY_PATH, INPUT_FILE, "result1.csv");
        assertFalse(csvResult.isSuccess());
    }

    @Test
    private void readExistingProcessFileToNullResultReturnFalse() throws IOException {
        csvResult = csvReadService.readProcessFile(DIRECTORY_PATH, INPUT_FILE, null);
        assertFalse(csvResult.isSuccess());
    }

    @Test
    private void readNotCSVProcessFileToNotExistingResultReturnFalse() throws IOException {
        csvResult = csvReadService.readProcessFile(DIRECTORY_PATH, "data.txt", RESULT_FILE);
        assertFalse(csvResult.isSuccess());
    }

    @Test
    private void deleteExistingFileReturnTrue() throws IOException {
        Boolean deletedFile = csvReadService.deleteFile(DIRECTORY_PATH, RESULT_FILE);
        assertTrue(deletedFile);
    }

    @Test
    private void deleteNotExistingFileReturnFalse() throws IOException {
        Boolean deletedFile = csvReadService.deleteFile(DIRECTORY_PATH, INPUT_FILE);
        assertFalse(deletedFile);
    }

    @Test
    private void deleteNullFileReturnFalse() throws IOException {
        Boolean deletedFile = csvReadService.deleteFile(DIRECTORY_PATH, null);
        assertFalse(deletedFile);
    }


}
//
//
//
//    @Test
//    void deleteFile() {
//    }
//
//    @Test
//    void writeFile() {
//    }
//    @Test
//    public void convertToUpperCaseNoSpacesenGLa_ndReturnENGLAND() throws Exception {
//        csvReadService = new CSVReadService();
//assertEquals(csvReadService.convertToUpperCaseNoSpaces("enGLa nd"), "ENGLAND");
//    }


