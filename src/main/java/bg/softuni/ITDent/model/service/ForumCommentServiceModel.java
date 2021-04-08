package bg.softuni.ITDent.model.service;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ForumCommentServiceModel {

    private String comment;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private LocalDateTime releaseData;
    private String user;
    private String forum;


    public ForumCommentServiceModel() {
    }

    public String getComment() {
        return comment;
    }

    public ForumCommentServiceModel setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public LocalDateTime getReleaseData() {
        return releaseData;
    }

    public ForumCommentServiceModel setReleaseData(LocalDateTime releaseData) {
        this.releaseData = releaseData;
        return this;
    }

    public String getUser() {
        return user;
    }

    public ForumCommentServiceModel setUser(String user) {
        this.user = user;
        return this;
    }

    public String getForum() {
        return forum;
    }

    public ForumCommentServiceModel setForum(String forum) {
        this.forum = forum;
        return this;
    }
}
