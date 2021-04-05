package bg.softuni.ITDent.repository;

import bg.softuni.ITDent.model.entities.ClinicEntity;
import bg.softuni.ITDent.model.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    List<CommentEntity> findAllByClinic(ClinicEntity clinic);
}
