package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import services.impl.UserServiceImpl;

import javax.xml.ws.http.HTTPException;
import java.util.List;

public class UserController extends Controller {

    public Result getUser(String id) {
        try {
            UserService userService = new UserServiceImpl();
            User user = userService.getUser(id);
            if (user == null) {
                return Controller.notFound("The requested user " + id + " is not found");
            }
            JsonNode json = Json.toJson(user);
            return Controller.ok(json);
        }
        catch (Exception ex){
            throw new HTTPException(INTERNAL_SERVER_ERROR);
        }
    }

    public Result getUsers() {
        try {
            UserService userService = new UserServiceImpl();
            List<User> users = userService.getUsers();
            JsonNode json = Json.toJson(users);
            return Controller.ok(json);
        }
        catch (Exception ex){
            throw new HTTPException(INTERNAL_SERVER_ERROR);
        }
    }
}
