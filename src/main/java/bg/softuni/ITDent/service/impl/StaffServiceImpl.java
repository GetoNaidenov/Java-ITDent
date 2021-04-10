package bg.softuni.ITDent.service.impl;

import bg.softuni.ITDent.model.entities.ClinicEntity;
import bg.softuni.ITDent.model.entities.StaffEntity;
import bg.softuni.ITDent.model.service.StaffServiceModel;
import bg.softuni.ITDent.repository.StaffRepository;
import bg.softuni.ITDent.service.ClinicService;
import bg.softuni.ITDent.service.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;


@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final ClinicService clinicService;
    private final ModelMapper modelMapper;


    public StaffServiceImpl(StaffRepository staffRepository, ClinicService clinicService, ModelMapper modelMapper) {
        this.staffRepository = staffRepository;
        this.clinicService = clinicService;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean nameExist(String name) {
        return staffRepository.findByInicial(name).isPresent();
    }

    @Override
    public void addStaff(StaffServiceModel staffServiceModel) {

        StaffEntity staffEntity = modelMapper.map(staffServiceModel,StaffEntity.class);
        ClinicEntity clinicEntity = clinicService.findByName(staffServiceModel.getClinicName()).orElseThrow(
                () -> new IllegalArgumentException("clinic not found"));

        staffEntity.setClinicEntity(clinicEntity);
        staffRepository.save(staffEntity);

    }

    @Override
    public List<StaffEntity> findAllById(Long id) {

        ClinicEntity clinicEntity = modelMapper.map(clinicService.findById(id),ClinicEntity.class);

        return staffRepository.findAllByClinicEntity(clinicEntity);
    }

    @Override
    public Long staffCount() {
        return staffRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        staffRepository.deleteById(id);
    }
}
