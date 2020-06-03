package src.main.java.org.volha.javatraining.csvspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.org.volha.javatraining.csvspringboot.mappers.ResidentMapper;
import src.main.java.org.volha.javatraining.csvspringboot.model.Resident;

import java.util.List;
@RestController
@RequestMapping("/residents")
public class ResidentController {

        private ResidentMapper residentMapper;

        @Autowired
        public ResidentController(ResidentMapper residentMapper){
            this.residentMapper = residentMapper;
        }

        @GetMapping("/all")
        public List<Resident> getAllResidents(){
            return residentMapper.findAllResidents();
        }


}
