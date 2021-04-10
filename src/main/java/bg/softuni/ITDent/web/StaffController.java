package bg.softuni.ITDent.web;

import bg.softuni.ITDent.model.binding.StaffAddBindingModel;
import bg.softuni.ITDent.model.entities.ClinicEntity;
import bg.softuni.ITDent.model.service.StaffServiceModel;
import bg.softuni.ITDent.model.view.ClinicViewModel;
import bg.softuni.ITDent.service.ClinicService;
import bg.softuni.ITDent.service.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/staffs")
public class StaffController {

    private final StaffService staffService;
    private final ClinicService clinicService;
    private final ModelMapper modelMapper;

    public StaffController(StaffService staffService, ClinicService clinicService, ModelMapper modelMapper) {
        this.staffService = staffService;
        this.clinicService = clinicService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("staffAddBindingModel")
    public StaffAddBindingModel staffAddBindingModel(){
        return  new StaffAddBindingModel();
    }

    @GetMapping("/add")
    public String add(@AuthenticationPrincipal UserDetails principal, Model model){
        model.addAttribute("clinic",clinicService.findAllMyClinics(principal.getUsername()));

        model.addAttribute("admin", true);
        return "add-staff";
    }

    @PostMapping("/add")
    public String add(@Valid StaffAddBindingModel staffAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("staffAddBindingModel",staffAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.staffAddBindingModel",bindingResult);

            return "redirect:/staffs/add";
        }


        if (staffService.nameExist(staffAddBindingModel.getInicial())){
            redirectAttributes.addFlashAttribute("staffAddBindingModel",staffAddBindingModel);
            redirectAttributes.addFlashAttribute("nameExist",true);

            return "redirect:/staffs/add";
        }

        StaffServiceModel staffServiceModel = modelMapper.map(
                staffAddBindingModel,StaffServiceModel.class);

           staffService.addStaff(staffServiceModel);

         return "redirect:/clinics/my";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id,Model model){

        model.addAttribute("staffs",staffService.findAllById(id));

        return "staffs";
    }

    @GetMapping("/delete/{id}")
    public String deleteStaff(@PathVariable Long id){
        staffService.deleteById(id);
        return "home";
    }
}
