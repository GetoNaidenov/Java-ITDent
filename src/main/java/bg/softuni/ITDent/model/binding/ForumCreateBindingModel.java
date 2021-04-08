package bg.softuni.ITDent.model.binding;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ForumCreateBindingModel {

    @NotNull
    @Size(min = 5, max = 50)
    private String name;
    private String description;


    public ForumCreateBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ForumCreateBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ForumCreateBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
