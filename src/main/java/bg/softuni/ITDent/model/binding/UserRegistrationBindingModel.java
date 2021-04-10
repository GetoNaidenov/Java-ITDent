package bg.softuni.ITDent.model.binding;
import bg.softuni.ITDent.model.validators.FieldMatch;
import javax.validation.constraints.*;

@FieldMatch(first = "password",second = "confirmPassword")


public class UserRegistrationBindingModel {

    @NotEmpty
    @Size(min = 3,max = 20)
    private String username;
    @NotEmpty
    @Size(min = 3,max = 30)
    private String fullname;
    @Min(1)
    @Max(100)
    private int age;
    @Email
    @Size(min = 5)
    private String email;
    @Size(min = 10,max = 15)
    private String number;
    @Size(min = 3,max = 20)
    private String password;
    @Size(min = 3,max = 20)
    private String confirmPassword;

    public UserRegistrationBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
