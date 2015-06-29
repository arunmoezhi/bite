package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.Route;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.ICommonService;
import services.IUserService;

import java.util.List;

@org.springframework.stereotype.Controller
public class CommonController {
    @Autowired
    private ICommonService cmnService;

    public Result getUsers(){
        List<Route> rts = cmnService.getAllRoutes();
        JsonNode json = Json.toJson(rts);
        return Controller.ok(json);
    }

}
