package bg.softuni.ITDent.web;

import bg.softuni.ITDent.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ClinicService clinicService;

    public HomeController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){

     model.addAttribute("clinics",clinicService.findAll());

        return "home";
    }

}
