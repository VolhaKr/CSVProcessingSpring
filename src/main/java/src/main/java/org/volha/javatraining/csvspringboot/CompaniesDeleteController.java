package src.main.java.org.volha.javatraining.csvspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/csvfile")
public class CompaniesDeleteController {
    //        private String filefolder = "D:\\Java\\JavaTraining\\";
//        static final String inputfile = "data_delete.csv";
    private static final int COMPANY_COLUMN = 0;
    private static final int COUNTRY_COLUMN = 1;
    private CompaniesDeleteService companiesDeleteService;

    @Autowired
    public CompaniesDeleteController(CompaniesDeleteService companiesDeleteService) {
        this.companiesDeleteService = companiesDeleteService;
    }

    @RequestMapping(method = POST, value = "/delete-company-country")
    public void deleteFileCompanies(@RequestBody CompaniesDeleteRequest companiesDeleteRequest) {
        System.out.println("Hello");
        System.out.println("folder " + companiesDeleteRequest.getCompaniesdeletefilelocation() + "file " + companiesDeleteRequest.getCompaniesdeletefilename());
        companiesDeleteService.deleteFileCompanies(companiesDeleteRequest.getCompaniesdeletefilelocation(), companiesDeleteRequest.getCompaniesdeletefilename());
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


    }
}

