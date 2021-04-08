package bg.softuni.ITDent.model.view;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ForumCommentViewModel {
    private String comment;
    private LocalDateTime releaseDate;
    private String creator;

    public ForumCommentViewModel() {
    }

    public String getComment() {
        return comment;
    }

    public ForumCommentViewModel setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public ForumCommentViewModel setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public ForumCommentViewModel setCreator(String creator) {
        this.creator = creator;
        return this;
    }
}
