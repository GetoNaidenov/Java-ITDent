package bg.softuni.ITDent.model.service;

import javax.persistence.Column;

public class StaffServiceModel {
    private String inicial;
    private String picUrl;
    private String description;
    private String clinicName;


    public StaffServiceModel() {
    }

    public String getClinicName() {
        return clinicName;
    }

    public StaffServiceModel setClinicName(String clinicName) {
        this.clinicName = clinicName;
        return this;
    }

    public String getInicial() {
        return inicial;
    }

    public StaffServiceModel setInicial(String inicial) {
        this.inicial = inicial;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public StaffServiceModel setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StaffServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
