package bg.softuni.ITDent.service.impl;

import bg.softuni.ITDent.model.entities.*;
import bg.softuni.ITDent.model.entities.enums.ClinicType;
import bg.softuni.ITDent.model.entities.enums.UserRole;
import bg.softuni.ITDent.model.service.ClinicCreateServiceModel;
import bg.softuni.ITDent.model.service.StaffServiceModel;
import bg.softuni.ITDent.model.view.ClinicViewModel;
import bg.softuni.ITDent.repository.ClinicRepository;
import bg.softuni.ITDent.repository.ClinicTypeRepository;
import bg.softuni.ITDent.repository.UserRepository;
import bg.softuni.ITDent.repository.UserRoleRepository;
import bg.softuni.ITDent.service.ClinicService;
import bg.softuni.ITDent.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClinicServiceImpl implements ClinicService {

    private final UserService userService;
    private final ClinicTypeRepository clinicTypeRepository;
    private final ClinicRepository clinicRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    public ClinicServiceImpl(UserService userService, ClinicTypeRepository clinicTypeRepository, ClinicRepository clinicRepository,  UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userService = userService;
        this.clinicTypeRepository = clinicTypeRepository;
        this.clinicRepository = clinicRepository;

        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedClinicType() {
        if (clinicTypeRepository.count() == 0){

            ClinicTypeEntity cardiologyType = new ClinicTypeEntity().setType(ClinicType.CARDIOLOGY);
            ClinicTypeEntity dentistryType = new ClinicTypeEntity().setType(ClinicType.DENTISTRY);
            ClinicTypeEntity dermatologyType = new ClinicTypeEntity().setType(ClinicType.DERMATOLOGY);
            ClinicTypeEntity earNoseThroatType = new ClinicTypeEntity().setType(ClinicType.EAR_NOSE_THROAT);
            ClinicTypeEntity gastroenterologyType = new ClinicTypeEntity().setType(ClinicType.GASTROENTEROLOGY);
            ClinicTypeEntity  gynecologyType = new ClinicTypeEntity().setType(ClinicType.GYNECOLOGY);
            ClinicTypeEntity  orthopedicsType = new ClinicTypeEntity().setType(ClinicType.ORTHOPEDICS);
            ClinicTypeEntity  podiatryType =  new ClinicTypeEntity().setType(ClinicType.PODIATRY);
            ClinicTypeEntity  urologyType = new ClinicTypeEntity().setType(ClinicType.UROLOGY);
            ClinicTypeEntity  physicalTherapyType = new ClinicTypeEntity().setType(ClinicType.PHYSICAL_THERAPY);
            ClinicTypeEntity multispecialtyType = new ClinicTypeEntity().setType(ClinicType.MULTISPECIALTY);
            clinicTypeRepository.saveAll(List.of(cardiologyType,dentistryType,dermatologyType,
                   earNoseThroatType,gastroenterologyType,gynecologyType,orthopedicsType,
                    podiatryType,urologyType,physicalTherapyType,multispecialtyType));
        }
    }

    @Override
    public boolean nameExist(String name) {

        return clinicRepository.findByName(name).isPresent();

    }

    @Override
    public void createClinic(ClinicCreateServiceModel serviceModel) {
        ClinicEntity clinicEntity = modelMapper.map(serviceModel,ClinicEntity.class);

        System.out.println(clinicEntity);
        UserEntity creator = userService.findByUserName(serviceModel.getUserEntity());



        UserRoleEntity userRoleEntity = userRoleRepository.findByRole(UserRole.ADMIN).orElseThrow(
                () -> new IllegalArgumentException("User role not found.")
        );


        if (clinicEntity.getImageUrl() == null){
            clinicEntity.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBPHY6WoM3sF3uoHTcE79-Gz2Mpm1i47yDgw&usqp=CAU");
        }


        creator.addRole(userRoleEntity);
        userService.saveUser(creator);
        creator = userService.findByUserName(serviceModel.getUserEntity());

        System.out.println(creator);
        clinicEntity.setUserEntity(creator);


        System.out.println(creator);
        clinicRepository.save(clinicEntity);

    }

    @Override
    public ClinicViewModel findById(Long id) {
        return clinicRepository.findById(id).map(clinicEntity -> {
            ClinicViewModel clinicViewModel = modelMapper.map(clinicEntity,ClinicViewModel.class);

            return clinicViewModel;
        }).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<ClinicEntity> findAll() {
        return clinicRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        clinicRepository.deleteById(id);

    }

    @Override
    public void deleteByName(String name) {
        clinicRepository.deleteByName(name);
    }

    @Override
    public Optional<ClinicEntity> findByName(String name) {
        return clinicRepository.findByName(name);
    }





    @Override
    public List<ClinicEntity> findAllMyClinics(String name) {

        List<ClinicEntity> myClinics = clinicRepository.findAll();
        UserEntity user = userService.findByUserName(name);

        List<ClinicEntity> result = new ArrayList<>();

        for(ClinicEntity c : myClinics){

            if (c.getUserEntity().getId().equals(user.getId()) ){
                result.add(c);
            }
        }

        return result;
    }

    @Override
    public Long clinicCount() {
        return clinicRepository.count();
    }
}
