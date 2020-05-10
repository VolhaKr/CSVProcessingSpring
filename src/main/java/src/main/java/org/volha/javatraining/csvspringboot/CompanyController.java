package src.main.java.org.volha.javatraining.csvspringboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import org.apache.logging.log4j.core.Logger;
//import java.util.logging.Logger;

import java.util.List;


    @RestController
    @RequestMapping("/companies")
    public class CompanyController {
        private CompanyService companyService;
        //private static final Logger LOG = Logger.getLogger(CompanyController.class);

        @Autowired
        public CompanyController(CompanyService companyService) {
            this.companyService = companyService;
        }

        @GetMapping("/list")
        public ResponseEntity<List<Company>> getCompanyList() {
            try {
                return new ResponseEntity<>(companyService.list(), HttpStatus.OK);
            } catch (Exception e) {
                //  LOG.error(e);
                System.err.println(e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @GetMapping(path = "/list/{companyname}")
        public Company getCompany(@PathVariable("companyname") String companyName) {
            return companyService.getCompany(companyName);
        }

//    @GetMapping(value ="/list/{companyname}")
//    public Company getCompany(@PathVariable String companyName) {
//        return companyService.getCompany(companyName);
//    }

//    @GetMapping("/list/{companyname}")
//    public Company getCompany(@PathVariable String companyName) {
//        return companyService.getCompany(companyName);
//    }


        @RequestMapping(method = RequestMethod.POST, value = "/new")
        public ResponseEntity addCompany(@RequestBody Company company) {
            if (company==null || company.getCompanyName()==null)
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
            companyService.addCompany(company);
            return ResponseEntity.accepted().build();
        }

        @RequestMapping(method = RequestMethod.PUT, value = "/update/{companyname}")
        public void updateCompany(@RequestBody Company companyNew, @PathVariable("companyname") String companyName) {
            companyService.updateCompany(companyName, companyNew);
        }

        @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{companyname}")
        public ResponseEntity<String> deleteCompany(@PathVariable("companyname") String companyName) {
            boolean removedCompany =  companyService.deleteCompany(companyName);
            if (removedCompany){
                return ResponseEntity.ok().build();
            }
            else {
                return new ResponseEntity("Could not find company "+companyName, HttpStatus.NOT_FOUND);
            }

//       DELETE WITH RESPONSE ENTITY
//
//        @RequestMapping(method = RequestMethod.DELETE, value = "/list/{companyname}")
//        public ResponseEntity deleteCompany(@PathVariable("companyname") String companyName) {
//            try {
//       return new ResponseEntity<>(companyService.deleteCompany(companyName), HttpStatus.OK);
//        } catch (Exception e) {
//            //LOG.error(e);
//            System.err.println(e);
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//       }



            //companyService.deleteCompany(companyName);


//    @GetMapping("delete")
//    public ResponseEntity<String> delete() {
//        try {
//            return new ResponseEntity<>(fiatService.removeFiatNotOnApi(), HttpStatus.OK);
//        } catch (Exception e) {
//            LOG.error(e);
//            System.err.println(e);
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
        }


    }
