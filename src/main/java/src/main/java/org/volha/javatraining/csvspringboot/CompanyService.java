package src.main.java.org.volha.javatraining.csvspringboot;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


    @Service
    public class CompanyService {

        private final Company company;
        private  final List<Company> companyList = new ArrayList<>(Arrays.asList(new Company("LTD", "ENGLANG"),
                new Company("MC", "GERMANY"),
                new Company("ABC", "ENGLANG"),
                new Company("!L PRODUCTIONS LIMITED", "ENGLAND,"
                )));


//    List<Company> companyList = new ListBinding<Company>() {
//        @Override
//        protected ObservableList<Company> computeValue() {
//            return null;
//        }
//    };

        @Autowired
        public CompanyService(Company company) {
            this.company = company;
        }

//    public String getCompany (String companyName) {
//        return company.getCompanyName();
//    }

        public List<Company> list() {
//        companyList.add(new Company("LTD", "ENGLANG"));
//        companyList.add(new Company("MC", "GERMANY"));
//        companyList.add(new Company("ABC", "ENGLANG"));
            return companyList;
        }
//
//companyList.
//        return new ArrayList<>(Arrays.asList(new CompanyDao("LTD", "ENGLANG"),
//         new CompanyDao("MC", "GERMANY"),
//                new CompanyDao("ABC", "ENGLANG")));
//        //List<CompanyDao> companyList = companyDao.list();
        //companyList.forEach(item->item.setHoldinhType (HoldingTypeFiat));

        //companyDao.forEach(item -> item.get());
        //  return companyList;


        public void addCompany(Company company) {
            if (!(companyList.contains(company)))
            companyList.add(company);
        }

//
//Company(String companyName) {
//        return companyList.stream().filter(t -> t.getCompanyName().equals(companyName)).findFirst().get();
//    }

        public void updateCompany(String companyName, Company companyNew) {

            for (int i = 0; i <= companyList.size(); i++) {
                Company companyGiven = companyList.get(i);
                if (companyGiven.getCompanyName().equals(companyName)) {
                    companyList.set(i, companyNew);
                    return;
                }
            }
        }
//add the same about country?
        public boolean deleteCompany(String companyName) {
            return companyList.removeIf(t -> t.getCompanyName().equals(companyName));
        }

        public Company getCompany(String companyName) {
            //  Optional companyListOptional = Optional.of(companyList);
            //Company companyOther = new Company("1", "ENGLAND");
            //  if (company.getCompanyName().equals(companyName).isPresent()) {
            Company tempCompany = null;
            try {
                tempCompany = companyList.stream().filter(t -> t.getCompanyName().equals(companyName)).findFirst().orElseThrow(NoSuchElementException::new);
            } catch (Exception e) {
                // e.printStackTrace();
                System.out.println("The list doesn't contain the company you want to get");
            }
            return tempCompany;
        }


//    public Company getCompany(String companyName) {
//        Company tempCompany= null;
//        if (Optional.of(company.getCompanyName()).isPresent()) {
//            tempCompany = companyList.stream().filter(t -> t.getCompanyName().equals(companyName)).findFirst().get();
//        }
//        return tempCompany;
//    }


//    public String getCompanyCountry(String companyName) {
//        Company tempCompany = companyList.stream().filter(t -> t.getCompanyName().equals(companyName)).findFirst().get();
//        return tempCompany.getCompanyCountry;
//    }


////public List<CompanyDao> list(){
////    return new Array<>(Arrays.asList(new CompanyDao("LTD", "ENGLANG"),
////            new CompanyDao("MC", "GERMANY"),
////            new CompanyDao("ABC", "ENGLANG")));
////
////}
//
//    public CompanyDao get
//
//
//    public String removeFiatNotOnApi() throws UnirestException {
//        List<Fiat> list = list();
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (Fiat fiat : list) {
//            if(currencyService.getCurrentPrice(fiat.getAcronym(), "USD") == -1) {
//                stringBuilder.append(fiat.getAcronym());
//                fiatDao.delete(fiat.getAcronym());
//            }
//        }
////
////        String[] deleteThis = {
////                "SVC USD",
////                "UYU UYI",
////                "ZAR LSL",
////                "ZAR NAD"
////        };
////
////        for (String deleteThi : deleteThis) {
////            fiatDao.delete(deleteThi);
////        }
////
//        return stringBuilder.toString();
//    }

    }







