package bg.softuni.ITDent.repository;

import bg.softuni.ITDent.model.entities.ClinicTypeEntity;
import bg.softuni.ITDent.model.entities.UserRoleEntity;
import bg.softuni.ITDent.model.entities.enums.ClinicType;
import bg.softuni.ITDent.model.entities.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClinicTypeRepository extends JpaRepository<ClinicTypeEntity,Long> {

    Optional<ClinicTypeEntity> findByType(ClinicType type);

}
