package bg.softuni.ITDent.web;

import bg.softuni.ITDent.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ClinicService clinicService;
    private final ForumService forumService;
    private final UserService userService;
    private final CommentService commentService;
    private final StaffService staffService;

    public HomeController(ClinicService clinicService, ForumService forumService, UserService userService, CommentService commentService, StaffService staffService) {
        this.clinicService = clinicService;
        this.forumService = forumService;
        this.userService = userService;
        this.commentService = commentService;
        this.staffService = staffService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("clinicCount",clinicService.clinicCount());
        model.addAttribute("forumCount",forumService.forumCount());
        model.addAttribute("userCount",userService.userCount());
        model.addAttribute("commentCount",commentService.commentCount());
        model.addAttribute("staffCount",staffService.staffCount());
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){

     model.addAttribute("clinics",clinicService.findAll());

        return "home";
    }

}
