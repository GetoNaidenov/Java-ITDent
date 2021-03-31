package bg.softuni.ITDent.repository;

import bg.softuni.ITDent.model.entities.ClinicEntity;
import bg.softuni.ITDent.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClinicRepository extends JpaRepository<ClinicEntity,Long> {

    List<ClinicEntity> findByUserEntity(UserEntity user);

    Optional<ClinicEntity> findByName(String name);

    Optional<ClinicEntity> findById(Long id);

    void deleteById(Long id);

    void deleteByName(String name);

}
