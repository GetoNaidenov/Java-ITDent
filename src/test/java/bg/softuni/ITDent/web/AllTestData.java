package bg.softuni.ITDent.web;

import bg.softuni.ITDent.model.entities.UserEntity;
import bg.softuni.ITDent.model.entities.UserRoleEntity;
import bg.softuni.ITDent.model.entities.enums.UserRole;
import bg.softuni.ITDent.repository.*;

public class AllTestData {

    private long testUserId;

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;


    public AllTestData( UserRepository userRepository,UserRoleRepository userRoleRepository) {
        this.userRepository=userRepository;
        this.userRoleRepository = userRoleRepository;

    }
   public void init(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("Geto");
        userEntity.setFullname("Geto Naidenov");
        userEntity.setEmail("geto@mail.bg");
        userEntity.setNumber("0888103010");
        userEntity.setAge(23);
        userEntity.setPassword("1234");

        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setRole(UserRole.ADMIN);
        UserRoleEntity userRoleEntity1 = new UserRoleEntity();
        userRoleEntity1.setRole(UserRole.USER);
        userRoleRepository.save(userRoleEntity1);
        userRoleRepository.save(userRoleEntity);

        userEntity.addRole(userRoleEntity);
        userEntity.addRole(userRoleEntity1);
        userEntity = userRepository.save(userEntity);

        testUserId = userEntity.getId();


   }




    void cleanUp(){
        userRepository.deleteAll();

    }
    public long getTestUserId(){
        return testUserId;
    }

}
