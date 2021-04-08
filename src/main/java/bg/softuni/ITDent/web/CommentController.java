package bg.softuni.ITDent.web;

import bg.softuni.ITDent.model.binding.CreateCommentBindingModel;
import bg.softuni.ITDent.model.entities.CommentEntity;
import bg.softuni.ITDent.model.service.CommentServiceModel;
import bg.softuni.ITDent.model.view.ClinicViewModel;
import bg.softuni.ITDent.service.ClinicService;
import bg.softuni.ITDent.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final ModelMapper modelMapper;
    private final CommentService commentService;
    private final ClinicService clinicService;

    public CommentController(ModelMapper modelMapper, CommentService commentService, ClinicService clinicService) {
        this.modelMapper = modelMapper;
        this.commentService = commentService;
        this.clinicService = clinicService;
    }

    @ModelAttribute("createCommentBindingModel")
    public CreateCommentBindingModel createCommentBindingModel(){
        return new CreateCommentBindingModel();
    }


    @GetMapping("/add/{id}")
    public String addComment(@PathVariable Long id, Model model){

        List<CommentEntity> comments = commentService.findAllByClinic(id);
        ClinicViewModel clinicViewModel = clinicService.findById(id);
        model.addAttribute("clinic",clinicViewModel);
        model.addAttribute("comments",comments);
        return "add-comment";
    }

    @PostMapping("/add/{id}")
    public String addComment(@PathVariable Long id,
            @Valid CreateCommentBindingModel createCommentBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal UserDetails principal){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("createCommentBindingModel",createCommentBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createCommentBindingModel",bindingResult);

            return "redirect:/comments/add/{id}";
        }

        CommentServiceModel commentModel = modelMapper.map(createCommentBindingModel, CommentServiceModel.class);
        ClinicViewModel clinicViewModel =clinicService.findById(id);
        commentModel.setUser(principal.getUsername());
        commentModel.setClinic(clinicViewModel.getName());
        commentModel.setReleaseData(LocalDateTime.now());
        commentService.addComment(commentModel);


        return "redirect:/comments/add/{id}";
    }



}
