package src.main.java.org.volha.javatraining.csvspringboot;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.nio.file.Paths;

@Service
public class CompaniesDeleteService {


    private static final int COMPANY_COLUMN = 0;
    private static final int COUNTRY_COLUMN = 1;
    private final CompanyService companyService;
    // private CompaniesDeleteResult companiesDeleteResult = new CompaniesDeleteResult();

    @Autowired
    public CompaniesDeleteService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public void deleteFileCompanies(String directoryPath, String inputFile) {
        System.out.println("Add test - read Process file");
        String inputFilePath = String.valueOf(Paths.get(directoryPath + inputFile));

        System.out.println("we are adding companies - take inpuFile path" + inputFilePath);
        deleteLineByLine(inputFilePath);
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

    private void deleteLineByLine(String inputFilePath) {
        try {
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(1).build();
            String[] nextRecord = new String[0];
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("YES, adding");
                System.out.println("Delete company " + nextRecord[0] + " add " + nextRecord[COMPANY_COLUMN]);
                companyService.deleteCompany(nextRecord[COMPANY_COLUMN]);
                System.out.println("delete company " + nextRecord[0] + " add " + nextRecord[COUNTRY_COLUMN]);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}






