package bg.softuni.ITDent.service;

import bg.softuni.ITDent.model.entities.ClinicEntity;
import bg.softuni.ITDent.model.service.ClinicCreateServiceModel;
import bg.softuni.ITDent.model.view.ClinicViewModel;

import java.util.List;
import java.util.Optional;


public interface ClinicService {
    void seedClinicType();

    boolean nameExist(String name);

    void createClinic(ClinicCreateServiceModel serviceModel);

    ClinicViewModel findById(Long id);

    List<ClinicEntity> findAll();

    void deleteById(Long id);

    void deleteByName(String name);

   Optional<ClinicEntity> findByName(String name);

    List<ClinicEntity> findAllMyClinics(String name);
}
