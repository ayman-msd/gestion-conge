package com.Project.SpringAngular.service;

import com.Project.SpringAngular.DTO.congeDTO;
import com.Project.SpringAngular.DTO.congesaveDTO;
import com.Project.SpringAngular.DTO.congeupdateDTO;

import java.util.List;

public interface congeservice {
    String addconge(congesaveDTO congesaveDTO);

    List<congeDTO> getallconges();

    String updateconge(congeupdateDTO congeupdateDTO);

    boolean deleteconge(int id);
}
