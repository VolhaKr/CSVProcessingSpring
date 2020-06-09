package src.main.java.org.volha.javatraining.csvspringboot.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import src.main.java.org.volha.javatraining.csvspringboot.model.Country;

import java.util.List;

public interface CompanyCountryMapper {

    @Select("select name from country " +
            "where country.name = #{companyCountry};")
    List<String> getCountry(String companyCountry);

@Insert("insert into country (name)"+"values(#{countryName})")
    void  insertCompanyCountryIfNotExists (String countryName);

    @Select("select id from country where country.name = #{companyCountry}")
        int getCompanyCountryFK(String companyCountry);

    List<String> getCompany(String companyName, String companyCountry);

    //  void insertCompanyCountryIfNotExists();

}
