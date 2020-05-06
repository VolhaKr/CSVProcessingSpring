package src.main.java.org.volha.javatraining.csvspringboot;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;

import java.io.FileReader;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

@Service

public class CsvReaderService {
    private static final int COMPANY_COLUMN = 0;
    private static final int COUNTRY_COLUMN = 8;
    static TreeMap<Country, TreeSet<String>> countryCompanies = new TreeMap<>();
    private CsvReaderResult csvReaderResult = new CsvReaderResult();

    public CsvReaderResult readDataLineByLine(String directoryPath, String INPUT_FILE) {
        String inputFilePath = String.valueOf(Paths.get(directoryPath + INPUT_FILE));

        try {
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(1).build();


            String[] nextRecord = new String[0];

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                putToCountryCompanies(nextRecord[COUNTRY_COLUMN], nextRecord[COMPANY_COLUMN]);
//                System.out.print(nextRecord[COUNTRY_COLUMN] + "\t");
//                System.out.print(nextRecord[COMPANY_COLUMN] + "\t");
//                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
            csvReaderResult.setSuccess(false);
            csvReaderResult.setMessage("Problems reading .csv file occured.");

        }
        return csvReaderResult;
    }

    private String convertToUpperCaseNoSpaces(String country) {
        String tempConvertedString = country.replaceAll("\\s+", "_");
        return tempConvertedString.trim().toUpperCase();
    }


    private void putToCountryCompanies(String country, String company) {
        String countryToAdd = convertToUpperCaseNoSpaces(country);
        Country countryToAddEnum = Country.NONE;

//        if ((countryToAdd.equals("")) || (countryToAdd.isEmpty())) {
//            countryToAdd = "NONE";
//        }
        boolean isValidCountryEnum = Arrays.stream(Country.values()).anyMatch(currentCountry -> currentCountry.name().equals(countryToAdd));
        if (isValidCountryEnum) {
            countryToAddEnum = Country.valueOf(countryToAdd);
        }
        try {
            TreeSet<String> companiesForCurrentCountry;
            if (countryCompanies.containsKey(countryToAddEnum)) {
                companiesForCurrentCountry = countryCompanies.get(countryToAddEnum);
            } else {
                companiesForCurrentCountry = new TreeSet<String>();
            }
            System.out.println("country" + countryToAdd + "company " + company);
            //System.out.println("company" + company);
            companiesForCurrentCountry.add(company);
            //System.out.println("set" + companiesForCurrentCountry);
            countryCompanies.put(countryToAddEnum, companiesForCurrentCountry);
        } catch (Exception e) {
            e.printStackTrace();
            csvReaderResult.setSuccess(false);
            csvReaderResult.setMessage("Countries in CSV are not in the allowed enum");
            System.out.println("Countries in CSV are not in the allowed enum");
        }
    }
}
