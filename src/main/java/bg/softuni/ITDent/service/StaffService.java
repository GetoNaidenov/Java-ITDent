package bg.softuni.ITDent.service;


import bg.softuni.ITDent.model.entities.StaffEntity;
import bg.softuni.ITDent.model.service.StaffServiceModel;

import java.awt.*;
import java.util.List;

public interface StaffService {

    boolean nameExist(String name);

    void addStaff(StaffServiceModel staffServiceModel);

    List<StaffEntity> findAllById(Long id);
}
