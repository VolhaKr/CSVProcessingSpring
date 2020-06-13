package src.main.java.org.volha.javatraining.csvspringboot.mappers;

import org.apache.ibatis.annotations.*;
import src.main.java.org.volha.javatraining.csvspringboot.model.Company;
import src.main.java.org.volha.javatraining.csvspringboot.model.CompanyResident;
//import src.main.java.org.volha.javatraining.csvspringboot.model.CompanyResident;

import java.util.List;

@Mapper
public interface CompanyMapper {
    @Select("select company.id, company.company_name, country.name from company, country where company.company_country_id = country.id;")
    List<CompanyResident> findAllCompaniesResidents();

    @Select("select company.id, company.company_name, country.name from company, country " +
            "where ((company.company_country_id = country.id)&(country.name = #{country}));")
    List<CompanyResident> findAllCompaniesResidentsFromSpecificCountry(String country);

    @Insert("insert into company(company_name,company_country_id) values(#{companyName},#{companyCountryFK})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "companyID",
            before = false, resultType = Integer.class)
    void insertCompany(String companyName, int companyCountryFK);

    @Select("SELECT EXISTS (SELECT * FROM company, country WHERE company.company_name = #{companyName} AND country.name = #{companyCountry} AND company.company_country_id = country.id);")
    boolean checkIfCompanyExists(String companyName, String companyCountry);


    //????How to select only ID????? THis dpesn't work
    @Select("SELECT company.id FROM company, country WHERE company.company_name = #{companyName} AND country.name = #{companyCountry} AND company.company_country_id = country.id);")
    List<Integer> selectSpecificCompanyID(String companyName, String companyCountry);

    //?????AND company.company_country_id = country.id - is not necessary if data are consistent???
    @Select("SELECT company.id FROM company, country WHERE company.company_name = #{companyName} AND country.name = #{companyCountry} AND company.company_country_id = country.id;")
    List<CompanyResident> selectSpecificCompany(String companyName, String companyCountry);


    @Update("UPDATE company " +
            "SET company.company_country_id = #{companyCountryFK}, " +
            "company.company_name = #{companyName} " +
            "WHERE company.company_name = #{companyToUpdateName}" +
            "& company.company_country_id = #{companyCountryFK}")
    void updateCompany(String companyToUpdateName, String companyName, int companyCountryFK);

    @Delete(" DELETE company FROM company, country WHERE company.company_name = #{companyName}" +
            "AND country.name = #{companyCountry} AND company.company_country_id = country.id;")
    void deleteCompany(String companyName, String companyCountry);

    // how to make delete from company with where in table
    @Delete("DELETE FROM company " +
            "WHERE company.company_name = #{companyName} AND country.name = #{companyCountry} AND company.company_country_id = country.id;")
    void deleteCompanyNotWorking(String companyName, String companyCountry);
}


////UPDATE employees
//SET
//    email = 'mary.patterson@classicmodelcars.com'
//WHERE
//    employeeNumber = 1056;