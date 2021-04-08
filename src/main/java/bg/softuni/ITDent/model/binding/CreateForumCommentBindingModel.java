package bg.softuni.ITDent.model.binding;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateForumCommentBindingModel {

    @NotNull
    @Size(min = 5)
    private String comment;


    public CreateForumCommentBindingModel() {
    }

    public String getComment() {
        return comment;
    }

    public CreateForumCommentBindingModel setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
