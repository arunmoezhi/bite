package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.Cuisine;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.IUserService;
import views.html.index;

import java.util.List;

import static play.libs.Jsonp.jsonp;

@org.springframework.stereotype.Controller
public class UserController extends Controller {
    @Autowired
    private IUserService usrService;

    public Result getUsers(String callback) {
        List<User> usrs = usrService.getAllUsers();
        JsonNode json = Json.toJson(usrs);
        return Controller.ok(jsonp(callback, json));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result addUser() {
        Http.RequestBody body = request().body();
        Cuisine usr = Json.fromJson(body.asJson(), Cuisine.class);
        return Controller.ok(Json.toJson("User Added Successfully : " + body.asJson()));
    }

}
