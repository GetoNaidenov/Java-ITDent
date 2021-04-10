package bg.softuni.ITDent.model.binding;

import bg.softuni.ITDent.model.entities.enums.WorkDays;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;


public class ClinicCreateBindingModel {
    @NotEmpty
    @Size(min = 3,max = 20)
    private String name;
    @NotEmpty
    @Size(min = 3,max = 20)
    private String city;
    @NotEmpty
    @Size(min = 5,max = 20)
    private String address;
    @NotEmpty
    @Size(min = 10,max = 15)
    private String phone;
    @NotNull
    @NotEmpty
    private String type;
    private String imageUrl;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime openTime;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime closeTime;
    @NotNull
    private WorkDays workDays;


    public ClinicCreateBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ClinicCreateBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ClinicCreateBindingModel setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ClinicCreateBindingModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ClinicCreateBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ClinicCreateBindingModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getType() {
        return type;
    }

    public ClinicCreateBindingModel setType(String type) {
        this.type = type;
        return this;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public ClinicCreateBindingModel setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
        return this;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public ClinicCreateBindingModel setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public WorkDays getWorkDays() {
        return workDays;
    }

    public ClinicCreateBindingModel setWorkDays(WorkDays workDays) {
        this.workDays = workDays;
        return this;
    }

    @Override
    public String toString() {
        return "ClinicCreateBindingModel{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", workDays=" + workDays +
                '}';
    }
}
