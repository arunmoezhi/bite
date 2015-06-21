package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.libs.Json;
import play.mvc.Result;
import services.UserService;
import views.html.index;

@org.springframework.stereotype.Controller
public class UserApp {
    @Autowired
    private UserService usrService;

    public Result addUser() {
        Form<User> form = Form.form(User.class).bindFromRequest();
        User usr = form.get();
        usrService.addUser(usr);
        return play.mvc.Controller.ok(Json.toJson("Added Successfully"));
    }

    public Result getUser(String userId) {
        return play.mvc.Controller.ok(Json.toJson(usrService.getUser(userId)));
    }
}
