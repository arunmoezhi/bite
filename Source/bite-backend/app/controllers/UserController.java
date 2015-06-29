package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.IUserService;
import views.html.index;

import java.util.List;

@org.springframework.stereotype.Controller
public class UserController {
    @Autowired
    private IUserService usrService;

    public Result getUsers(){
        List<User> usrs = usrService.getAllUsers();
        JsonNode json = Json.toJson(usrs);
        return Controller.ok(json);
    }

}
