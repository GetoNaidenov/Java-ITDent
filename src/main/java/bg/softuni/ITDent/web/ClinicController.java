package bg.softuni.ITDent.web;

import bg.softuni.ITDent.model.binding.ClinicCreateBindingModel;
import bg.softuni.ITDent.model.service.ClinicCreateServiceModel;
import bg.softuni.ITDent.model.view.ClinicViewModel;
import bg.softuni.ITDent.service.ClinicService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.Id;
import javax.validation.Valid;

@Controller
@RequestMapping("/clinics")
public class ClinicController {

private final ClinicService clinicService;
private final ModelMapper modelMapper;

    public ClinicController(ClinicService clinicService, ModelMapper modelMapper) {
        this.clinicService = clinicService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("clinicCreateBindingModel")
    public ClinicCreateBindingModel clinicCreateBindingModel(){
        return  new ClinicCreateBindingModel();
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid ClinicCreateBindingModel clinicCreateBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               @AuthenticationPrincipal UserDetails principal

                               ){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("clinicCreateBindingModel",clinicCreateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.clinicCreateBindingModel",bindingResult);

            return "redirect:/clinics/create";
        }

        if (clinicService.nameExist(clinicCreateBindingModel.getName())){
            redirectAttributes.addFlashAttribute("clinicCreateBindingModel",clinicCreateBindingModel);
            redirectAttributes.addFlashAttribute("nameExist",true);

            return "redirect:/clinics/create";
        }



        System.out.println(clinicCreateBindingModel);
        ClinicCreateServiceModel clinicCreateServiceModel = modelMapper.map(
               clinicCreateBindingModel,ClinicCreateServiceModel.class  );


        clinicCreateServiceModel.setUserEntity(principal.getUsername());
        System.out.println(clinicCreateServiceModel);
        clinicService.createClinic(clinicCreateServiceModel);

        return "redirect:/home";

    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){

        ClinicViewModel clinicViewModel = clinicService.findById(id);

        model.addAttribute("clinic",clinicViewModel);

        return "details";
    }

    @GetMapping("/delete/{id}")
        public String deleteClinic(@PathVariable Long id){

        clinicService.deleteById(id);

        return "home";
    }

    @GetMapping("/my")
    public String my(@AuthenticationPrincipal UserDetails principal,Model model){

        model.addAttribute("clinics",clinicService.findAllMyClinics(principal.getUsername()));

        return "my";
    }




}
