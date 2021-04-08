package bg.softuni.ITDent.model.view;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class ForumViewModel {

    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private LocalDate releaseDate;
    private String creator;
    private String description;

    public ForumViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ForumViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ForumViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public ForumViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public ForumViewModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public ForumViewModel setCreator(String creator) {
        this.creator = creator;
        return this;
    }
}
