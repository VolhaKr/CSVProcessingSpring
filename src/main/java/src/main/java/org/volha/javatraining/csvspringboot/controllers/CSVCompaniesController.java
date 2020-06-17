package src.main.java.org.volha.javatraining.csvspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.org.volha.javatraining.csvspringboot.services.CSVCompaniesService;
import src.main.java.org.volha.javatraining.csvspringboot.resource.FilePathRequest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/csvfile")
public class CSVCompaniesController {
    private final CSVCompaniesService csvCompaniesService;

    @Autowired
    public CSVCompaniesController(CSVCompaniesService csvCompaniesService) {
        this.csvCompaniesService = csvCompaniesService;
    }

    @RequestMapping(method = POST, value = "/add-csv-company-country")
    public void addFileCompanies(@RequestBody FilePathRequest filePathRequest) {
        System.out.println("add folder " + filePathRequest.getLocation() + "file " + filePathRequest.getName());
        csvCompaniesService.addFileCompaniesToDBList(filePathRequest.getLocation(), filePathRequest.getName());
    }

    @RequestMapping(method = POST, value = "/delete-csv-company-country")
    public void deleteFileCompanies(@RequestBody FilePathRequest filePathRequest) {
        System.out.println("Hello");
        System.out.println("folder " + filePathRequest.getLocation() + "file " + filePathRequest.getLocation());
        csvCompaniesService.deleteFileCompaniesFromDB(filePathRequest.getLocation(), filePathRequest.getName());
    }
}







