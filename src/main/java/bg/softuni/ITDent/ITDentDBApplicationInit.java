package bg.softuni.ITDent;

import bg.softuni.ITDent.service.ClinicService;
import bg.softuni.ITDent.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ITDentDBApplicationInit implements CommandLineRunner {

    private final UserService userService;
    private final ClinicService clinicService;

    public ITDentDBApplicationInit(UserService userService, ClinicService clinicService) {
        this.userService = userService;
        this.clinicService = clinicService;
    }


    @Override
    public void run(String... args) throws Exception {
        userService.seedUserRole();
        clinicService.seedClinicType();
    }
}
