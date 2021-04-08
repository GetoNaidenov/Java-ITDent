package bg.softuni.ITDent.web;

import bg.softuni.ITDent.model.binding.CreateCommentBindingModel;
import bg.softuni.ITDent.model.binding.CreateForumCommentBindingModel;
import bg.softuni.ITDent.model.binding.ForumCreateBindingModel;
import bg.softuni.ITDent.model.entities.ForumEntity;
import bg.softuni.ITDent.model.service.CommentServiceModel;
import bg.softuni.ITDent.model.service.ForumCommentServiceModel;
import bg.softuni.ITDent.model.service.ForumCreateServiceModel;
import bg.softuni.ITDent.model.view.ClinicViewModel;
import bg.softuni.ITDent.model.view.ForumCommentViewModel;
import bg.softuni.ITDent.model.view.ForumViewModel;
import bg.softuni.ITDent.service.ForumCommentsService;
import bg.softuni.ITDent.service.ForumService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;



@Controller
@RequestMapping("/forums")
public class ForumController {

    private final ModelMapper modelMapper;
    private final ForumService forumService;


    public ForumController(ModelMapper modelMapper, ForumService forumService) {
        this.modelMapper = modelMapper;
        this.forumService = forumService;

    }


    @ModelAttribute("forumCreateBindingModel")
    public ForumCreateBindingModel forumCreateBindingModel(){
        return new ForumCreateBindingModel();
    }


    @GetMapping("/all")
    public String getAllForums(Model model) {
        model.addAttribute("forums",forumService.findAll());
        return "all-Forums";
    }

    @PostMapping("/add")
    public String addForum(@Valid ForumCreateBindingModel forumCreateBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails principal) {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("forumCreateBindingModel",forumCreateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.forumCreateBindingModel", bindingResult);

            return "redirect:/forums/add";
        }
        if (forumService.nameExist(forumCreateBindingModel.getName())){
            redirectAttributes.addFlashAttribute("forumCreateBindingModel",forumCreateBindingModel());
            redirectAttributes.addFlashAttribute("nameExist",true);

            System.out.println(forumService.nameExist(forumCreateBindingModel.getName()));

            return "redirect:/forums/add";
        }

        ForumCreateServiceModel forumCreateServiceModel = modelMapper.map(forumCreateBindingModel, ForumCreateServiceModel.class);
        forumCreateServiceModel.setCreator(principal.getUsername());
        forumCreateServiceModel.setReleaseDate(LocalDate.now());
        forumService.saveForum(forumCreateServiceModel);

        return "redirect:/forums/all";
    }

    @GetMapping("/add")
    public String addForum(){
        return "add-Forum";
    }





}
