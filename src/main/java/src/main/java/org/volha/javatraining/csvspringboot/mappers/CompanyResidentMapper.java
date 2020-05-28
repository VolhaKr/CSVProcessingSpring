package src.main.java.org.volha.javatraining.csvspringboot.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import src.main.java.org.volha.javatraining.csvspringboot.model.CompanyResident;
import src.main.java.org.volha.javatraining.csvspringboot.model.Resident;

import java.util.List;

    @Mapper
    public interface CompanyResidentMapper {
        @Select("select company.id, company.company_name, country.name from company, country where company.company_country_id = country.id;")
        List<CompanyResident> findAllCompaniesResidents();
    }
