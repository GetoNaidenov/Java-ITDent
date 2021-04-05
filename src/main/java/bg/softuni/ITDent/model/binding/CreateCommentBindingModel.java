package bg.softuni.ITDent.model.binding;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
public class CreateCommentBindingModel {

    @NotEmpty
    @Size(min = 1)
    private String comment;


    public CreateCommentBindingModel() {
    }

    public String getComment() {
        return comment;
    }

    public CreateCommentBindingModel setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
