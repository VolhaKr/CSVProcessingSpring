package src.main.java.org.volha.javatraining.csvspringboot.mappers;

import org.apache.ibatis.annotations.Select;
import src.main.java.org.volha.javatraining.csvspringboot.model.Company;

public interface CountryMapper {


//    @Select(SELECT * FROM company)
//    List<Company> findAll();
    @Select("SELECT * FROM company WHERE id = #{id}")
    Company selectCompany(int id);
}
