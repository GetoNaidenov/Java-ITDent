package bg.softuni.ITDent.model.service;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class ForumCreateServiceModel {

    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private String creator;
    private String description;

    public ForumCreateServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ForumCreateServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public ForumCreateServiceModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public ForumCreateServiceModel setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ForumCreateServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ForumCreateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }
}
