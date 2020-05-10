package src.main.java.org.volha.javatraining.csvspringboot;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeSet;

@Service
public class CSVCompaniesAddService {
    private static final int COMPANY_COLUMN = 0;
    private static final int COUNTRY_COLUMN = 1;

    private CSVCompaniesAddService csvCompaniesAddService;
    private CompanyService companyService;
    private CsvReadService csvReadService;

    @Autowired
    public CSVCompaniesAddService(CompanyService companyService, CsvReadService csvReadService) {
        this.companyService = companyService;
        this.csvReadService = csvReadService;
    }

//    @Autowired
//    public CSVCompaniesAddService(CsvReadService csvReadService) {
//        this.csvReadService = csvReadService;
//    }

    public void addFileCompanies(String directoryPath, String inputFile) {
        System.out.println("Adding companies - read Add file");
        String inputFilePath = String.valueOf(Paths.get(directoryPath + inputFile));
        System.out.println("We are adding companies - from inpuFile path" + inputFilePath);
        addLineByLine(inputFilePath);
//        if (csvReadResult.isSuccess()) {
//            if (deleteFile(directoryPath, resultFile)) {
//                System.out.println("File deletion " + deleteFile(directoryPath, resultFile));
//                writeFile(directoryPath, resultFile);
//            } else {
//                csvReadResult.setSuccess(false);
//                csvReadResult.setMessage("Problems deleting old .csv result file");
//            }
//        }
//        System.out.println(csvReadResult.getMessage());
//        return csvReadResult;

    }

    private void addLineByLine(String inputFilePath) {
        try {
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(1).build();
            String[] nextRecord = new String[0];
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("YES, adding");
                System.out.println("Add company " + nextRecord[0] + " add " + nextRecord[COUNTRY_COLUMN]);
                putToCompanyList(nextRecord[1], nextRecord[0]);

            }
        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void putToCompanyList(String company, String country) {
        Country countryToAdd = Country.valueOf(country);
//            boolean isValidCountryEnum = Arrays.stream(Country.values()).anyMatch(currentCountry -> currentCountry.name().equals(countryToAdd));
//            if (isValidCountryEnum) {
                companyService.addCompany(new Company(company, country));
//            }
//             else {
//                 System.out.println("Countries in CSV are not in the allowed enum");
//            }
        }
    }




