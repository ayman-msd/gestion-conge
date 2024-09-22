package com.Project.SpringAngular.servicecontroller;


import com.Project.SpringAngular.DTO.serviceDTO;
import com.Project.SpringAngular.DTO.servicesaveDTO;
import com.Project.SpringAngular.DTO.serviceupdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/service")


public class servicecontroller {

    @Autowired
    private com.Project.SpringAngular.service.serviceservice serviceservice;

    @PostMapping(path ="/save")
    public String saveservice(@RequestBody servicesaveDTO servicesaveDTO) {
        String id = serviceservice.addservice(servicesaveDTO);
        return id;
    }

    @GetMapping(path ="/getallservices")
    public List<serviceDTO> getallservices(){
        List<serviceDTO>allservices=serviceservice.getallservices();
        return allservices;
    }

    @PostMapping(path ="/update")
    public String updateservice(@RequestBody serviceupdateDTO serviceupdateDTO) {
        String id = serviceservice.updateservice(serviceupdateDTO);
        return id;
    }

    @DeleteMapping(path ="/deleteservice/{id}")
    public String deleteservice(@PathVariable(value="id") int id) {
        boolean deleteservice = serviceservice.deleteservice(id);
        return "deleted";
    }


}
