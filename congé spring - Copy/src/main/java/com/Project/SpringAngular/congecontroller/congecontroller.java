package com.Project.SpringAngular.congecontroller;

import com.Project.SpringAngular.DTO.congeDTO;
import com.Project.SpringAngular.DTO.congesaveDTO;
import com.Project.SpringAngular.DTO.congeupdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Project.SpringAngular.service.congeservice;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/conge")
public class congecontroller {

    @Autowired
    private congeservice congeservice;

    @PostMapping(path ="/save")
    public String saveconge(@RequestBody congesaveDTO congesaveDTO) {
        String id = congeservice.addconge(congesaveDTO);
        return id;
    }

    @GetMapping(path ="/getallconges")
    public List<congeDTO> getallconges(){
        List<congeDTO>allconges=congeservice.getallconges();
        return allconges;
    }

    @PostMapping(path ="/update")
    public String updateconge(@RequestBody congeupdateDTO congeupdateDTO) {
        String id = congeservice.updateconge(congeupdateDTO);
        return id;
    }

    @DeleteMapping(path ="/deleteconge/{id}")
    public String deleteconge(@PathVariable(value="id") int id) {
        boolean deleteconge = congeservice.deleteconge(id);
        return "deleted";
    }


}
