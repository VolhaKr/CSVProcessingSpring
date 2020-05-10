package src.main.java.org.volha.javatraining.csvspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/csvfile")
public class CvsReadController {
    //    private String UPLOADED_FOLDER = "D:\\Java\\JavaTraining\\";
//    static final String INPUT_FILE = "data.csv";
//    public static final String RESULT_FILE = "result.csv";
    private static final int COMPANY_COLUMN = 0;
    private static final int COUNTRY_COLUMN = 8;
    static TreeMap<Country, TreeSet<String>> countryCompanies = new TreeMap<>();

    private CsvReadService csvReadService;

    @Autowired
    public CvsReadController(CsvReadService csvReadService) {
        this.csvReadService = csvReadService;
    }
//    @GetMapping(path = "{csvreaderresult}")
//    public Company getCompany(@PathVariable("csvreaderresult") boolean false) {
//        return companyService.csvResult;
//    }

//        String inputFilePath = String.valueOf(Paths.get(UPLOADED_FOLDER
//                + org.volha.javatraining.springbootexample.csvprocessingpojo.CSVFileApplication.RESULT_FILE));

    // @PostMapping(value = "/read-company-country-file")
    // public void readCSVFile() {
//            System.out.println("All the companies are in the file " + inputFilePath);
    //ArrayList<Company> readCompanies = new ArrayList<>();


//    @RequestMapping(method = RequestMethod.POST, value = "/new")
//    public ResponseEntity addCompany(@RequestBody Company company) {
//

    @RequestMapping(method = POST, value = "/read-company-country")
    public ResponseEntity readCSVFile(@RequestBody CsvReadRequest csvReadRequest) {
//                String inputFilePath = String.valueOf(Paths.get(UPLOADED_FOLDER
//             + CSVFileApplication.RESULT_FILE));
        System.out.println("Hello");
        System.out.println("folder    " + csvReadRequest.getFileLocation() + "file " + csvReadRequest.getInputfilename() + "out " + csvReadRequest.getOutpufilename());
        CsvReadResult csvReadResult = csvReadService.readProcessFile(csvReadRequest.getFileLocation(), csvReadRequest.getInputfilename(), csvReadRequest.getOutpufilename());
        System.out.println(" row 53 folder" + csvReadRequest.getFileLocation() + "file" + csvReadRequest.getInputfilename());
        System.out.println(csvReadResult.isSuccess());
        //csvReadService.readDataLineByLine(directoryPath, String INPUT_FILE);
        if (csvReadResult.isSuccess()) {
            return ResponseEntity.ok().build();
        } else return new ResponseEntity<>(csvReadResult.getMessage(), HttpStatus.NOT_FOUND);

    }
}










