package bg.softuni.ITDent.model.entities;

import bg.softuni.ITDent.model.entities.enums.ClinicType;
import bg.softuni.ITDent.model.entities.enums.WorkDays;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clinics")
public class ClinicEntity extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @Column(name = "open_time", nullable = false)
    private LocalTime openTime;
    @Column(name = "close_time", nullable = false)
    private LocalTime closeTime;
    @Enumerated(EnumType.STRING)
    private WorkDays workDays;
    @ManyToOne
    private UserEntity userEntity;
    @Enumerated(EnumType.STRING)
    private ClinicType type;


    public ClinicEntity() {
    }

    public String getName() {
        return name;
    }

    public ClinicEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;

    }

    public ClinicType getType() {
        return type;
    }

    public ClinicEntity setType(ClinicType type) {
        this.type = type;
        return this;
    }

    public ClinicEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ClinicEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhone() {
        return phone;
    }

    public ClinicEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public ClinicEntity setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
        return this;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public ClinicEntity setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public WorkDays getWorkDays() {
        return workDays;
    }

    public ClinicEntity setWorkDays(WorkDays workDays) {
        this.workDays = workDays;
        return this;
    }

    @Override
    public String toString() {
        return "ClinicEntity{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", workDays=" + workDays +
                ", userEntity=" + userEntity +
                ", type=" + type +
                '}';
    }
}
