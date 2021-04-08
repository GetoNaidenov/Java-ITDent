package bg.softuni.ITDent.service;

import bg.softuni.ITDent.model.entities.ForumEntity;
import bg.softuni.ITDent.model.service.ForumCreateServiceModel;
import bg.softuni.ITDent.model.view.ForumCommentViewModel;
import bg.softuni.ITDent.model.view.ForumViewModel;

import java.util.List;
import java.util.Optional;

public interface ForumService {
    List<ForumViewModel> findAll();

    void saveForum(ForumCreateServiceModel forumCreateServiceModel);

    boolean nameExist(String name);

    ForumViewModel findById(Long id);



    Optional<ForumEntity> findByName(String forum);

    Long forumCount();
}
