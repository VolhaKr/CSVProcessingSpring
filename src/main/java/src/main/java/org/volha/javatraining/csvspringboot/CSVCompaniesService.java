package src.main.java.org.volha.javatraining.csvspringboot;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.nio.file.Paths;

@Service
public class CSVCompaniesService {
    private static final int COMPANY_COLUMN = 1;
    private static final int COUNTRY_COLUMN = 0;

    private final CompanyService companyService;

    @Autowired
    public CSVCompaniesService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public void addFileCompaniesToDB(String directoryPath, String inputFile) {
        System.out.println("Adding companies - read Add file");
        String inputFilePath = takePath(directoryPath, inputFile);
        //String inputFilePath = String.valueOf(Paths.get(directoryPath + inputFile));
        //  String inputFilePath = (Paths.get(directoryPath + inputFile)).toAbsolutePath().toString();
        System.out.println("We are adding companies - from inpuFile path" + inputFilePath);
        processLineByLine(inputFilePath, "add");
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

    private String takePath(String directoryPath, String inputFile) {
        return String.valueOf(Paths.get(directoryPath + inputFile));
    }

//    private void addLineByLine(String inputFilePath) {
//        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(1).build();) {
//            String[] nextRecord = new String[0];
//            while ((nextRecord = csvReader.readNext()) != null) {
//                System.out.println("YES, adding");
//                System.out.println("Add company " + nextRecord[COMPANY_COLUMN] + " add " + nextRecord[COUNTRY_COLUMN]);
//                putToCompanyList(nextRecord[COMPANY_COLUMN], nextRecord[COUNTRY_COLUMN]);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }

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

    public void deleteFileCompaniesFromDB(String directoryPath, String inputFile) {
        System.out.println("Add test - read Process file");
        String inputFilePath = takePath(directoryPath, inputFile);
        System.out.println("we are deleting companies - take inpuFile path" + inputFilePath);
        processLineByLine(inputFilePath, "delete");
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

//    private void deleteLineByLine(String inputFilePath) {
//        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(1).build();) {
//            String[] nextRecord = new String[0];
//            while ((nextRecord = csvReader.readNext()) != null) {
//                System.out.println("YES, deleting");
//                System.out.println("Delete company " + nextRecord[COMPANY_COLUMN] + " delete " + nextRecord[COUNTRY_COLUMN]);
//                companyService.deleteCompany(nextRecord[COMPANY_COLUMN], nextRecord[COUNTRY_COLUMN]);
//                System.out.println("deleting is called for "+ nextRecord[COMPANY_COLUMN]);
//                              }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }


    private void processLineByLine(String inputFilePath, String operation) {
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(1).build();) {
            String[] nextRecord = new String[0];
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println(operation + nextRecord[COMPANY_COLUMN] + operation + "country" + nextRecord[COUNTRY_COLUMN]);
                switch (operation) {
                    // case statements
                    // values must be of same type of expression
                    case "delete":
                        companyService.deleteCompany(nextRecord[COMPANY_COLUMN], nextRecord[COUNTRY_COLUMN]);
                        break;


                    case "add":
                        putToCompanyList(nextRecord[COMPANY_COLUMN], nextRecord[COUNTRY_COLUMN]);
                        break;

                }
                System.out.println(operation + nextRecord[COMPANY_COLUMN]);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}




