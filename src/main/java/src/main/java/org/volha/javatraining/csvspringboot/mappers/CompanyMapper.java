package src.main.java.org.volha.javatraining.csvspringboot.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import src.main.java.org.volha.javatraining.csvspringboot.model.Company;

import java.util.List;

@Mapper
public interface CompanyMapper {
    @Select("Select * from company")
    List<Company> findAllCompanies();
}

