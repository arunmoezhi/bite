package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import play.libs.Json;
import play.mvc.*;

import services.IUserService;
import views.html.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Application {
    @Autowired
    private IUserService usrService;

    public Result index() {
        return play.mvc.Controller.ok(index.render("Hello World"));
    }

    public Result getUsers(){
        List<User> usrs = usrService.getAllUsers();
        JsonNode json = Json.toJson(usrs);
        return play.mvc.Controller.ok(json);
    }

}
