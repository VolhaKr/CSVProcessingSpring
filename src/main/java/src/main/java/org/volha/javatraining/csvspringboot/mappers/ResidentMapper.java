package src.main.java.org.volha.javatraining.csvspringboot.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import src.main.java.org.volha.javatraining.csvspringboot.model.Resident;

import java.util.List;

@Mapper
public interface ResidentMapper {
    @Select("select resident.residentID, resident.first_name, resident.second_name, resident.address, country.name from resident, country where resident.country = country.id;")
    List<Resident> findAllResidents();
}
