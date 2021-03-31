package bg.softuni.ITDent.model.view;


import bg.softuni.ITDent.model.entities.enums.ClinicType;
import bg.softuni.ITDent.model.entities.enums.WorkDays;
import java.time.LocalTime;

public class ClinicViewModel {
    private String id;
    private String name;
    private String city;
    private String address;
    private String phone;
    private String imageUrl;
    private LocalTime openTime;
    private LocalTime closeTime;
    private WorkDays workDays;
    private ClinicType type;

    public ClinicViewModel() {
    }

    public String getName() {
        return name;
    }

    public ClinicViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ClinicViewModel setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ClinicViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getId() {
        return id;
    }

    public ClinicViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public ClinicViewModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ClinicViewModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public ClinicViewModel setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
        return this;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public ClinicViewModel setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public WorkDays getWorkDays() {
        return workDays;
    }

    public ClinicViewModel setWorkDays(WorkDays workDays) {
        this.workDays = workDays;
        return this;
    }

    public ClinicType getType() {
        return type;
    }

    public ClinicViewModel setType(ClinicType type) {
        this.type = type;
        return this;
    }
}
