package bg.softuni.ITDent.service.impl;

import bg.softuni.ITDent.model.entities.UserEntity;
import bg.softuni.ITDent.model.entities.UserRoleEntity;
import bg.softuni.ITDent.model.entities.enums.UserRole;
import bg.softuni.ITDent.model.service.UserRegistrationServiceModel;
import bg.softuni.ITDent.repository.UserRepository;
import bg.softuni.ITDent.repository.UserRoleRepository;
import bg.softuni.ITDent.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final ITDentDBUserService itDentDBUserService;


    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, ITDentDBUserService itDentDBUserService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.itDentDBUserService = itDentDBUserService;
    }

    @Override
    public void seedUserRole(){

        if (userRoleRepository.count() == 0){
            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRole.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRole.USER);

            userRoleRepository.saveAll(List.of(adminRole,userRole));
        }


    }

    @Override
    public UserEntity findByUserName(String userName) {
        return userRepository.findByUsername(userName).orElseThrow(IllegalAccessError::new);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public Long userCount() {
        return userRepository.count();
    }


    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel serviceModel){
        UserEntity newUser = modelMapper.map(serviceModel,UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        UserRoleEntity userRole = userRoleRepository.findByRole(UserRole.USER).orElseThrow(
                () -> new IllegalStateException("User role not found."));

                newUser.addRole(userRole);
                newUser = userRepository.save(newUser);

        UserDetails principal = itDentDBUserService.loadUserByUsername(newUser.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

    }




    @Override
    public boolean userNameExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}
