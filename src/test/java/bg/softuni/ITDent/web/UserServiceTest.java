package bg.softuni.ITDent.web;

import bg.softuni.ITDent.model.entities.UserEntity;
import bg.softuni.ITDent.model.entities.UserRoleEntity;
import bg.softuni.ITDent.model.entities.enums.UserRole;
import bg.softuni.ITDent.repository.UserRepository;
import bg.softuni.ITDent.repository.UserRoleRepository;
import bg.softuni.ITDent.service.impl.ITDentDBUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private ITDentDBUserService serviceTest;

    @Mock
    UserRepository mockUserRepository;
    UserRoleRepository userRoleRepository;

    @BeforeEach
    public void setUp(){
        serviceTest = new ITDentDBUserService(mockUserRepository,userRoleRepository);
    }

    @Test
    void testUserNotFound(){
        Assertions.assertThrows(
                UsernameNotFoundException.class,() ->{
                    serviceTest.loadUserByUsername("user_does_not_exist");
                }
        );
    }


    @Test
    void testExistUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("geto");
        userEntity.setFullname("Geto Naidenov");
        userEntity.setEmail("geto@mail.bg");
        userEntity.setNumber("0888103010");
        userEntity.setAge(23);
        userEntity.setPassword("1234");

        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setRole(UserRole.ADMIN);
        UserRoleEntity userRoleEntity1 = new UserRoleEntity();
        userRoleEntity1.setRole(UserRole.USER);

        userEntity.setRoles(List.of(userRoleEntity,userRoleEntity1));

        Mockito.when(mockUserRepository.findByUsername("geto"))
                .thenReturn(Optional.of(userEntity));

        UserDetails userDetails = serviceTest.loadUserByUsername("geto");

        Assertions.assertEquals(userEntity.getUsername(),userDetails.getUsername());
        Assertions.assertEquals(2,userDetails.getAuthorities().size());

        List<String> authorities = userDetails
                .getAuthorities().stream().map(
                        GrantedAuthority::getAuthority
                ).collect(Collectors.toList());

        Assertions.assertTrue(authorities.contains("ROLE_ADMIN"));
        Assertions.assertTrue(authorities.contains("ROLE_USER"));


    }


}
