package bg.softuni.ITDent.web;

import bg.softuni.ITDent.model.entities.ClinicEntity;
import bg.softuni.ITDent.model.entities.UserEntity;
import bg.softuni.ITDent.model.entities.enums.ClinicType;
import bg.softuni.ITDent.model.entities.enums.WorkDays;
import bg.softuni.ITDent.repository.ClinicRepository;
import bg.softuni.ITDent.repository.ClinicTypeRepository;
import bg.softuni.ITDent.repository.UserRoleRepository;
import bg.softuni.ITDent.service.UserService;
import bg.softuni.ITDent.service.impl.ClinicServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalTime;

@ExtendWith(MockitoExtension.class)
public class ClinicServiceTest {

    private UserEntity userEntity;
    private ClinicEntity clinicEntity;
    private ClinicServiceImpl clinicService;
    private UserService userService;

    @Mock
    ClinicRepository clinicRepository;

    @Mock
    ClinicTypeRepository clinicTypeRepository;

    @Mock
    UserRoleRepository userRoleRepository;


    @BeforeEach
    public void init(){
        userEntity = new UserEntity();
        userEntity.setUsername("test");

        clinicEntity = new ClinicEntity();
        clinicEntity.setUserEntity(userEntity);
        clinicEntity.setName("testName");
        clinicEntity.setAddress("my test address");
        clinicEntity.setPhone("0888103010");
        clinicEntity.setType(ClinicType.MULTISPECIALTY);
        clinicEntity.setCity("Sofia");
        clinicEntity.setWorkDays(WorkDays.EVERY_DAY);
        clinicEntity.setOpenTime(LocalTime.MIN);
        clinicEntity.setCloseTime(LocalTime.MAX);

        clinicService = new ClinicServiceImpl(userService,clinicTypeRepository,clinicRepository,userRoleRepository,new ModelMapper());

    }





}
