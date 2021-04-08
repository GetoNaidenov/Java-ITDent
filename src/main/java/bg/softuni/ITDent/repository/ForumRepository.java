package bg.softuni.ITDent.repository;

import bg.softuni.ITDent.model.entities.ForumEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForumRepository  extends JpaRepository<ForumEntity,Long> {
    List<ForumEntity> findAll();

    Optional<ForumEntity> findByName(String name);



}
