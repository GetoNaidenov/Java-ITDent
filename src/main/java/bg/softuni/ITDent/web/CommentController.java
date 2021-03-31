package bg.softuni.ITDent.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final ModelMapper modelMapper;

    public CommentController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }




}
