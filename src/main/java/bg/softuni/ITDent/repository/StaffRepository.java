package bg.softuni.ITDent.repository;
import bg.softuni.ITDent.model.entities.ClinicEntity;
import bg.softuni.ITDent.model.entities.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity,Long> {

    Optional<StaffEntity> findById(Long Id);

    List<StaffEntity> findAllByClinicEntity(ClinicEntity clinicEntity);

   Optional<StaffEntity> findByInicial(String initial);
}
