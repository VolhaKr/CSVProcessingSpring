package src.main.java.org.volha.javatraining.csvspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/csvfile")
public class CSVCompaniesAddController {
    //        private String filefolder = "D:\\Java\\JavaTraining\\";
//        static final String inputfile = "data_delete.csv";
    private static final int COMPANY_COLUMN = 0;
    private static final int COUNTRY_COLUMN = 1;
    private CSVCompaniesAddService csvCompaniesAddService;

    @Autowired
    public CSVCompaniesAddController(CSVCompaniesAddService csvCompaniesAddService) {
        this.csvCompaniesAddService = csvCompaniesAddService;
    }

    @RequestMapping(method = POST, value = "/add-company-country")
    public void addFileCompanies(@RequestBody CSVCompaniesAddRequest csvCompaniesAddRequest) {
        System.out.println("add folder " + csvCompaniesAddRequest.getCompaniesaddfilelocation() + "file " + csvCompaniesAddRequest.getCompaniesaddfilename());
        csvCompaniesAddService.addFileCompanies(csvCompaniesAddRequest.getCompaniesaddfilelocation(), csvCompaniesAddRequest.getCompaniesaddfilename());
    }
}

//                       if (removedCompany){
//                return ResponseEntity.ok().build();
//            }
//            else {
//                return new ResponseEntity("Could not delete company ", HttpStatus.NOT_FOUND);
//            }
//
//
//
//
//                   if (csvReadResult.isSuccess()) {
//                    return ResponseEntity.ok().build();
//                } else return new ResponseEntity<>(csvReadResult.getMessage(), HttpStatus.NOT_FOUND);









