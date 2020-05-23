package src.main.java.org.volha.javatraining.csvspringboot;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

@Service

public class CSVReadService {
    private static final int COMPANY_COLUMN = 0;
    private static final int COUNTRY_COLUMN = 8;
    static TreeMap<Country, TreeSet<String>> countryCompanies = new TreeMap<>();
    private CSVResult csvResult = new CSVResult();

    //    @Autowired
//    public CSVReadService(CSVResult csvResult) {
//       this.csvResult = csvResult;
//    }
    public CSVResult readProcessFile(String directoryPath, String inputFile, String resultFile) {
        System.out.println("test - read Process file" + directoryPath + inputFile);
        csvResult.setSuccess(false);
        String inputFilePath = getFilePath(directoryPath, inputFile);
        System.out.println("test - take inpuFile path" + inputFilePath);
        csvResult = readDataLineByLine(inputFilePath);
        if (deleteFile(directoryPath, resultFile)) {
            System.out.println("File deletion " + deleteFile(directoryPath, resultFile));
            writeFile(directoryPath, resultFile);
            csvResult.setSuccess(true);
        } else {
            csvResult.setSuccess(false);
            csvResult.setMessage("Problems processing .csv file");
        }

        System.out.println(csvResult.getMessage());
        return csvResult;

    }

    private static String getFilePath(String directoryPath, String fileName) {
        return (Paths.get(directoryPath + fileName)).toAbsolutePath().toString();
    }

    private CSVResult readDataLineByLine(String inputFilePath) {

//        System.out.println( "test" + directoryPath + inputFile);
//        String inputFilePath = String.valueOf(Paths.get(directoryPath + inputFile));

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
            csvResult.setSuccess(false);
            csvResult.setMessage("Problems reading .csv file occured." + e);

        } finally {
            csvResult.setSuccess(true);
        }
        return csvResult;
    }

    private String convertToUpperCaseNoSpaces(String country) {
        String tempConvertedString = country.replaceAll("\\s+", "");
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
            csvResult.setSuccess(false);
            csvResult.setMessage("Countries in CSV are not in the allowed enum");
            System.out.println("Countries in CSV are not in the allowed enum");
        }
    }

    public static boolean deleteFile(String directoryPath, String resultFile) {
        String fileToDelete = getFilePath(directoryPath, resultFile);
        System.out.println("File to delete " + fileToDelete);
        try {
            return Files.deleteIfExists(Paths.get(fileToDelete));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void writeFile(String directoryPath, String resultFile) {
        String fileToCreate = getFilePath(directoryPath, resultFile);
        System.out.println("Trying to create file in " + fileToCreate);
        File file = new File(fileToCreate);
        System.out.println("file is creted" + fileToCreate);
        //FileWriter outputFileWriter = null;
        try (FileWriter outputFileWriter = new FileWriter(file);) {
            //create FileWriter object with file as parameter

            // create CSVWriter object filewriter object as parameter

//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

            for (Map.Entry<Country, TreeSet<String>>
                    entry : countryCompanies.entrySet()) {
                Country country = entry.getKey();
                System.out.println(country + "" + entry.getValue());
            }

            try (CSVWriter writer = new CSVWriter(outputFileWriter);) {
                for (Map.Entry<Country, TreeSet<String>>
                        entry : countryCompanies.entrySet()) {
                    Country country = entry.getKey();
                    for (String company : entry.getValue()) {
                        String[] data = new String[2];
                        data[0] = String.valueOf(country);
                        data[1] = company;
                        writer.writeNext(data);
                        System.out.println(data[0] + data[1]);
//
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
