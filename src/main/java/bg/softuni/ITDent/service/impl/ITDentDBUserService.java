package bg.softuni.ITDent.service.impl;

import bg.softuni.ITDent.model.entities.UserEntity;
import bg.softuni.ITDent.repository.UserRepository;
import bg.softuni.ITDent.repository.UserRoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;



@Component
public class ITDentDBUserService implements UserDetailsService {

        private final UserRepository userRepository;
        private final UserRoleRepository userRoleRepository;

        public ITDentDBUserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
            this.userRepository = userRepository;
            this.userRoleRepository = userRoleRepository;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            bg.softuni.ITDent.model.entities.UserEntity userEntity = userRepository.
                    findByUsername(username).
                    orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " was not found!"));

            return mapToUserDetails(userEntity);
        }

        private UserDetails mapToUserDetails(UserEntity userEntity) {
            List<GrantedAuthority> authorities =
                    userEntity.
                            getRoles().
                            stream().
                            map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name())).
                            collect(Collectors.toList());

            return new User(
                    userEntity.getUsername(),
                    userEntity.getPassword(),
                    authorities
            );
        }





    }


