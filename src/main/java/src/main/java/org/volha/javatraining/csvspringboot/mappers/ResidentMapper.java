package src.main.java.org.volha.javatraining.csvspringboot.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import src.main.java.org.volha.javatraining.csvspringboot.model.Resident;

import java.util.List;

@Mapper
public interface ResidentMapper {
    @Select("Select * from resident")
    List<Resident> findAllResidents();
}
