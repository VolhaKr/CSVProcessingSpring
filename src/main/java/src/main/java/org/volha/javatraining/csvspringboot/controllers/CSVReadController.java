package src.main.java.org.volha.javatraining.csvspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.org.volha.javatraining.csvspringboot.resource.CSVReadRequest;
import src.main.java.org.volha.javatraining.csvspringboot.services.CSVReadService;
import src.main.java.org.volha.javatraining.csvspringboot.resource.CSVResult;
import src.main.java.org.volha.javatraining.csvspringboot.model.Country;
import java.util.TreeMap;
import java.util.TreeSet;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/csvfile")
public class CSVReadController {
    private static final int COMPANY_COLUMN = 0;
    private static final int COUNTRY_COLUMN = 8;
    static TreeMap<Country, TreeSet<String>> countryCompanies = new TreeMap<>();

    private final CSVReadService csvReadService;

    @Autowired
    public CSVReadController(CSVReadService csvReadService) {
        this.csvReadService = csvReadService;
    }

    @RequestMapping(method = POST, value = "/read-company-country")
    public ResponseEntity<?> readCSVFile(@RequestBody CSVReadRequest csvReadRequest) {
        System.out.println("Hello");
        System.out.println("folder    " + csvReadRequest.getFileLocation() + "file " + csvReadRequest.getInputFileName() + "out " + csvReadRequest.getOutputFileName());
        CSVResult csvResult = csvReadService.readProcessFile(csvReadRequest.getFileLocation(), csvReadRequest.getInputFileName(), csvReadRequest.getOutputFileName());
        System.out.println(" row 53 folder" + csvReadRequest.getFileLocation() + "file" + csvReadRequest.getInputFileName());
        System.out.println(csvResult.isSuccess());
        //csvReadService.readDataLineByLine(directoryPath, String INPUT_FILE);
        if (csvResult.isSuccess()) {
            return ResponseEntity.ok().build();
        } else return new ResponseEntity<>(csvResult.getMessage(), HttpStatus.NOT_FOUND);
    }
}










