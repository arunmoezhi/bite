package models;

import play.data.validation.Constraints;
import utils.FormModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    public String userId;

    @Constraints.Required(message = "The name is required")
    public String name;

    @Constraints.Required(message = "Email address is required")
    public String email;

    public String dob;

    public char gender;
}
