package bg.softuni.ITDent.service;

import bg.softuni.ITDent.model.service.ForumCommentServiceModel;
import bg.softuni.ITDent.model.view.ForumCommentViewModel;

import java.util.List;

public interface ForumCommentsService {
    List<ForumCommentViewModel> findAllById(Long id);

    void addComment(ForumCommentServiceModel commentModel);

    Long forumCommentCount();

}
