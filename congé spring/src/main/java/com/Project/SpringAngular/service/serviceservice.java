package com.Project.SpringAngular.service;

import com.Project.SpringAngular.DTO.serviceDTO;
import com.Project.SpringAngular.DTO.servicesaveDTO;
import com.Project.SpringAngular.DTO.serviceupdateDTO;

import java.util.List;

public interface serviceservice {
    String addservice(servicesaveDTO servicesaveDTO);

    List<serviceDTO> getallservices();

    String updateservice(serviceupdateDTO serviceupdateDTO);

    boolean deleteservice(int id);
}
