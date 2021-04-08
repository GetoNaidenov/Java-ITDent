package bg.softuni.ITDent.model.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "forums")
public class ForumEntity extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @ManyToOne
    private UserEntity creator;


    public String getName() {
        return name;
    }

    public ForumEntity setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public ForumEntity setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public ForumEntity setCreator(UserEntity creator) {
        this.creator = creator;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ForumEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
