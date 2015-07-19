package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.SqlQueries;
import utils.SqlWrapper;

import javax.xml.ws.http.HTTPException;

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
            String sql = SqlQueries.getInstance().getQuery("GetAllUsers");
            SqlWrapper sqlWrapper = new SqlWrapper();
            JsonNode json = Json.toJson(sqlWrapper.getMultipleData(sql));
            return Controller.ok(json);
        }
        catch (Exception ex){
            throw new HTTPException(INTERNAL_SERVER_ERROR);
        }
    }
}
