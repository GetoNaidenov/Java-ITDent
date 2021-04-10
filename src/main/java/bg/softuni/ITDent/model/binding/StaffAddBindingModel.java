package bg.softuni.ITDent.model.binding;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class StaffAddBindingModel {
    @NotEmpty
    @Size(min = 7,max = 20)
    private String inicial;
    @NotEmpty
    @Size(min = 10,max = 100)
    private String picUrl;
    @NotEmpty
    @Size(min = 10,max = 200)
    private String description;
    @NotEmpty
    private String clinicName;

    public StaffAddBindingModel() {
    }

    public String getInicial() {
        return inicial;
    }

    public String getClinicName() {
        return clinicName;
    }

    public StaffAddBindingModel setClinicName(String clinicName) {
        this.clinicName = clinicName;
        return this;
    }

    public StaffAddBindingModel setInicial(String inicial) {
        this.inicial = inicial;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public StaffAddBindingModel setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StaffAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
