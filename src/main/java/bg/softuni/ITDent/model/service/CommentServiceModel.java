package bg.softuni.ITDent.model.service;

import bg.softuni.ITDent.model.entities.ClinicEntity;
import bg.softuni.ITDent.model.entities.UserEntity;
import java.time.LocalDateTime;

public class CommentServiceModel {

    private String comment;
    private LocalDateTime releaseData;
    private String user;
    private String clinic;

    public CommentServiceModel() {
    }

    public String getComment() {
        return comment;
    }

    public CommentServiceModel setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public LocalDateTime getReleaseData() {
        return releaseData;
    }

    public CommentServiceModel setReleaseData(LocalDateTime releaseData) {
        this.releaseData = releaseData;
        return this;
    }

    public String getUser() {
        return user;
    }

    public CommentServiceModel setUser(String user) {
        this.user = user;
        return this;
    }

    public String getClinic() {
        return clinic;
    }

    public CommentServiceModel setClinic(String clinic) {
        this.clinic = clinic;
        return this;
    }
}
