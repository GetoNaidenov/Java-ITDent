package bg.softuni.ITDent.model.entities;

import bg.softuni.ITDent.model.entities.enums.ClinicType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class ClinicTypeEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private ClinicType type;


    public ClinicTypeEntity() {
    }

    public ClinicType getType() {
        return type;
    }

    public ClinicTypeEntity setType(ClinicType type) {
        this.type = type;
        return this;
    }
}
