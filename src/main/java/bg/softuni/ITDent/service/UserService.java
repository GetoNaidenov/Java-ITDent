package bg.softuni.ITDent.service;

import bg.softuni.ITDent.model.entities.UserEntity;
import bg.softuni.ITDent.model.service.UserRegistrationServiceModel;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserService {
    boolean userNameExist(String username);

    void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

    void seedUserRole();

   UserEntity findByUserName(String userName);

    void saveUser(UserEntity userEntity);

    Long userCount();
}
