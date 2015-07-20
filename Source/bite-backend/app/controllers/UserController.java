package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import services.impl.UserServiceImpl;
import utils.SqlQueries;
import utils.SqlWrapper;

import javax.xml.ws.http.HTTPException;
import java.util.List;

public class UserController extends Controller {
    public Result getUser(String id) {
        try {
            String sql = SqlQueries.getInstance().getQuery("GetUser", id);
            SqlWrapper sqlWrapper = new SqlWrapper();
            JsonNode json = Json.toJson(sqlWrapper.getSingleData(sql));
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
