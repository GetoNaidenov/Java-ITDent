package bg.softuni.ITDent.model.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "forum_Comments")
public class ForumCommentEntity extends BaseEntity{

    @Column(name = "comment",nullable = false, columnDefinition = "TEXT")
    private String comment;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private LocalDateTime releaseDate;
    @ManyToOne
    private UserEntity creator;
    @ManyToOne
    private ForumEntity forum;

    public ForumCommentEntity() {
    }

    public String getComment() {
        return comment;
    }

    public ForumCommentEntity setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public ForumCommentEntity setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public ForumCommentEntity setCreator(UserEntity creator) {
        this.creator = creator;
        return this;
    }

    public ForumEntity getForum() {
        return forum;
    }

    public ForumCommentEntity setForum(ForumEntity forum) {
        this.forum = forum;
        return this;
    }


}
