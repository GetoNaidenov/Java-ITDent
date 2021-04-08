package bg.softuni.ITDent.repository;

import bg.softuni.ITDent.model.entities.ForumCommentEntity;
import bg.softuni.ITDent.model.entities.ForumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumCommentRepository extends JpaRepository<ForumCommentEntity,Long> {

    List<ForumCommentEntity> findAllByForum(ForumEntity forumEntity);

}
