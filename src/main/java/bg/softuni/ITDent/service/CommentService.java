package bg.softuni.ITDent.service;

import bg.softuni.ITDent.model.entities.CommentEntity;
import bg.softuni.ITDent.model.service.CommentServiceModel;

import java.util.List;

public interface CommentService {
    void addComment(CommentServiceModel commentModel);

    List<CommentEntity> findAllByClinic(Long id);

    Long commentCount();
}
