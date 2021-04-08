package bg.softuni.ITDent.service.impl;
import bg.softuni.ITDent.model.entities.*;
import bg.softuni.ITDent.model.service.ForumCommentServiceModel;
import bg.softuni.ITDent.model.view.ForumCommentViewModel;
import bg.softuni.ITDent.repository.ForumCommentRepository;
import bg.softuni.ITDent.service.ForumCommentsService;
import bg.softuni.ITDent.service.ForumService;
import bg.softuni.ITDent.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumCommentsServiceImpl implements ForumCommentsService {

    private final ForumCommentRepository forumCommentRepository;
    private final ForumService forumService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public ForumCommentsServiceImpl(ForumCommentRepository forumCommentRepository, ForumService forumService, ModelMapper modelMapper, UserService userService) {
        this.forumCommentRepository = forumCommentRepository;
        this.forumService = forumService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @Override
    public List<ForumCommentViewModel> findAllById(Long id) {

       ForumEntity forum = modelMapper.map(forumService.findById(id),ForumEntity.class);

        return  forumCommentRepository.findAllByForum(forum).stream()
                .map(cm ->{
                    ForumCommentViewModel forumComment = modelMapper.map(cm,ForumCommentViewModel.class);
                    forumComment.setCreator(cm.getCreator().getUsername());
                    return forumComment;
                }).collect(Collectors.toList());
    }

    @Override
    public void addComment(ForumCommentServiceModel commentModel) {

        ForumCommentEntity commentEntity = modelMapper.map(commentModel,ForumCommentEntity.class);
        UserEntity creator = userService.findByUserName(commentModel.getUser());
        ForumEntity forum = forumService.findByName(commentModel.getForum()).orElseThrow(
                () -> new IllegalArgumentException("Clinic not found")
        );

        commentEntity.setCreator(creator);
        commentEntity.setForum(forum);


        forumCommentRepository.save(commentEntity);

    }

    @Override
    public Long forumCommentCount() {
        return forumCommentRepository.count();
    }
}
