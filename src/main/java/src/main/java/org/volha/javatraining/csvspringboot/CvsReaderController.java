package src.main.java.org.volha.javatraining.csvspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;
import java.util.TreeSet;

@RestController
@RequestMapping("/csvfile")
public class CvsReaderController {
    private String UPLOADED_FOLDER = "D:\\Java\\JavaTraining\\";
    static final String INPUT_FILE = "data.csv";
    public static final String RESULT_FILE = "result.csv";
    private static final int COMPANY_COLUMN = 0;
    private static final int COUNTRY_COLUMN = 8;
    static TreeMap<Country, TreeSet<String>> countryCompanies = new TreeMap<>();

    private CsvReaderService csvReaderService;

    @Autowired
    public CvsReaderController(CsvReaderService csvReaderService) {
        this.csvReaderService = csvReaderService;
    }
//    @GetMapping(path = "{csvreaderresult}")
//    public Company getCompany(@PathVariable("csvreaderresult") boolean false) {
//        return companyService.csvResult;
//    }

//        String inputFilePath = String.valueOf(Paths.get(UPLOADED_FOLDER
//                + org.volha.javatraining.springbootexample.csvprocessingpojo.CSVFileApplication.RESULT_FILE));

    @RequestMapping(method = RequestMethod.POST, value = "/read-company-country-file")
    // public void readCSVFile() {
//            System.out.println("All the companies are in the file " + inputFilePath);
    //ArrayList<Company> readCompanies = new ArrayList<>();


//    @RequestMapping(method = RequestMethod.POST, value = "/new")
//    public ResponseEntity addCompany(@RequestBody Company company) {
//


    public ResponseEntity readCSVFile(@RequestBody CsvReaderResult csvReaderResult) {
//                String inputFilePath = String.valueOf(Paths.get(UPLOADED_FOLDER
//             + CSVFileApplication.RESULT_FILE));

        csvReaderResult = csvReaderService.readDataLineByLine(UPLOADED_FOLDER, INPUT_FILE);
        //csvReaderService.readDataLineByLine(directoryPath, String INPUT_FILE);
        if (csvReaderResult.isSuccess()) {
            return ResponseEntity.ok().build();
        } else return new ResponseEntity(csvReaderResult.getMessage(), HttpStatus.NOT_FOUND);

    }
}










