package bg.softuni.ITDent.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "staffs")
public class StaffEntity extends BaseEntity {
    @Column(name = "inicials", nullable = false, unique = true)
    private String inicial;
    @Column(name = "pic_urls", nullable = false)
    private String picUrl;
    @Column(name = "descriptions", nullable = false)
    private String description;
    @ManyToOne
    private ClinicEntity clinicEntity;

    public StaffEntity() {
    }

    public String getInicial() {
        return inicial;
    }

    public StaffEntity setInicial(String inicial) {
        this.inicial = inicial;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public StaffEntity setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StaffEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public ClinicEntity getClinicEntity() {
        return clinicEntity;
    }

    public StaffEntity setClinicEntity(ClinicEntity clinicEntity) {
        this.clinicEntity = clinicEntity;
        return this;
    }
}
