package bg.softuni.ITDent.model.service;
import bg.softuni.ITDent.model.entities.enums.ClinicType;
import bg.softuni.ITDent.model.entities.enums.WorkDays;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;

public class ClinicCreateServiceModel {
    private Long id;
    private String name;
    private String city;
    private String address;
    private String phone;
    private String imageUrl;
    private LocalTime openTime;
    private LocalTime closeTime;
    private ClinicType type;
    private String userEntity;
    private WorkDays workDays;

    public ClinicCreateServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ClinicCreateServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCity() {
        return city;
    }

    public String getUserEntity() {
        return userEntity;
    }

    public WorkDays getWorkDays() {
        return workDays;
    }

    public ClinicCreateServiceModel setWorkDays(WorkDays workDays) {
        this.workDays = workDays;
        return this;
    }

    public ClinicCreateServiceModel setUserEntity(String userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public ClinicCreateServiceModel setCity(String city) {
        this.city = city;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ClinicCreateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ClinicCreateServiceModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ClinicCreateServiceModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public ClinicCreateServiceModel setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
        return this;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public ClinicCreateServiceModel setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public ClinicType getType() {
        return type;
    }

    public ClinicCreateServiceModel setType(ClinicType type) {
        this.type = type;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ClinicCreateServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public String toString() {
        return "ClinicCreateServiceModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", type=" + type +
                ", userEntity='" + userEntity + '\'' +
                ", workDays=" + workDays +
                '}';
    }
}
