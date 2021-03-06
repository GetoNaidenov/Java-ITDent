package bg.softuni.ITDent.model.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "coments")
public class CommentEntity extends BaseEntity {

      @Column(name = "comments",nullable = false)
      private String comment;
      @Column(name = "release_date",nullable = false)
      private LocalDateTime releaseData;
      @ManyToOne
      private UserEntity user;
      @ManyToOne
      private ClinicEntity clinic;

    public CommentEntity() {
    }

    public String getComment() {
        return comment;
    }

    public CommentEntity setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public CommentEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public ClinicEntity getClinic() {
        return clinic;
    }

    public CommentEntity setClinic(ClinicEntity clinic) {
        this.clinic = clinic;
        return this;
    }

    public LocalDateTime getReleaseData() {
        return releaseData;
    }

    public CommentEntity setReleaseData(LocalDateTime releaseData) {
        this.releaseData = releaseData;
        return this;
    }
}
