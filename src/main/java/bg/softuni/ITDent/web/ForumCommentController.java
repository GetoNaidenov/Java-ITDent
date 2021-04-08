package bg.softuni.ITDent.web;
import bg.softuni.ITDent.model.binding.CreateForumCommentBindingModel;
import bg.softuni.ITDent.model.service.ForumCommentServiceModel;
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
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/forums")
public class ForumCommentController {

    private final ModelMapper modelMapper;
    private final ForumCommentsService forumCommentsService;
    private final ForumService forumService;

    public ForumCommentController(ModelMapper modelMapper, ForumCommentsService forumCommentsService, ForumService forumService) {
        this.modelMapper = modelMapper;
        this.forumCommentsService = forumCommentsService;
        this.forumService = forumService;
    }


    @ModelAttribute("createForumCommentBindingModel")
    public CreateForumCommentBindingModel createForumCommentBindingModel(){
        return new CreateForumCommentBindingModel();
    }


    @GetMapping("/comment/{id}")
    public String details(@PathVariable Long id, Model model){
        ForumViewModel forum = forumService.findById(id);
        model.addAttribute("forum",forum);
        List<ForumCommentViewModel> comments = forumCommentsService.findAllById(id);
        model.addAttribute("comments",comments);

        return "forum-detail";
    }

    @PostMapping("/comment/{id}")
    public String details(@PathVariable Long id, @Valid CreateForumCommentBindingModel createForumCommentBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal UserDetails principal){


        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("createForumCommentBindingModel",createForumCommentBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createForumCommentBindingModel", bindingResult);

            return "redirect:/forums/comment/{id}";
        }



        ForumCommentServiceModel commentModel = modelMapper.map(createForumCommentBindingModel, ForumCommentServiceModel.class);
        commentModel.setUser(principal.getUsername());
        ForumViewModel forum =forumService.findById(id);
        commentModel.setForum(forum.getName());
        commentModel.setReleaseData(LocalDateTime.now());

        System.out.println(commentModel.getComment());
        forumCommentsService.addComment(commentModel);


        return "redirect:/forums/comment/{id}";
    }



}
