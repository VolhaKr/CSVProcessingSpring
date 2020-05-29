package src.main.java.org.volha.javatraining.csvspringboot.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import src.main.java.org.volha.javatraining.csvspringboot.Company;
import src.main.java.org.volha.javatraining.csvspringboot.model.CompanyResident;
import src.main.java.org.volha.javatraining.csvspringboot.model.Resident;

import java.util.List;

    @Mapper
    public interface CompanyResidentMapper {
        @Select("select company.id, company.company_name, country.name from company, country where company.company_country_id = country.id;")
        List<CompanyResident> findAllCompaniesResidents();

        @Insert("insert into company(company_name,company_country_id) values(#{companyName},#{companyCountryID})")
        @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty = "companyID",
        before = false, resultType = Integer.class)
        void insert (Company company);
    }
