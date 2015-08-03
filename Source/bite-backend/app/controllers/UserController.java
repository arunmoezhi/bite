package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import scala.concurrent.java8.FuturesConvertersImpl;
import services.UserService;
import services.impl.UserServiceImpl;

import javax.xml.ws.http.HTTPException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class UserController extends Controller {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";
    private static final String DOB = "dob";
    private static final String EMAIL = "email";
    private static final String GENDER = "gender";

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

    @BodyParser.Of(BodyParser.Json.class)
    public Result createUser() {
        /*
         Things pending in createUser.
         1. store password in a secure manner.
         */
        try {
            JsonNode json = request().body().asJson();
            ObjectMapper mapper = new ObjectMapper();
            @SuppressWarnings("unchecked")
            Map<String, Object> userInput = mapper.treeToValue(json, Map.class);
            User user = convertToUserObject(userInput);
            UserService userService = new UserServiceImpl();
            User createdUser  = userService.createUser(user);
            json = Json.toJson(createdUser);
            return Controller.created(json);
        } catch (HTTPException e) {
            if (e.getStatusCode() == Http.Status.CONFLICT) {
                return Controller.status(e.getStatusCode(), "The user already exists");
            } else if (e.getStatusCode() == Http.Status.BAD_REQUEST) {
                //Think of what nicer way to tell the bad request.
                return Controller.status(e.getStatusCode());
            } else {
                throw new HTTPException(e.getStatusCode());
            }
        } catch (JsonProcessingException e) {
            //NOT sure what type of exception to be thrown from controller.
            throw new RuntimeException(e);
        }
    }

    private User convertToUserObject(Map<String, Object> userInput) {
        User user = new User();
        boolean result = validateUserInput(userInput);
        if (result) {
            user.setFirstName((String)userInput.get(FIRST_NAME));
            user.setLastName((String)userInput.get(LAST_NAME));
            user.setUserName((String)userInput.get(USER_NAME));
            user.setPassword((String)userInput.get(PASSWORD));
            user.setEmail((String)userInput.get(EMAIL));
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                user.setDob(simpleDateFormat.parse((String) userInput.get(DOB)));
            } catch (ParseException e) {
                //ignoring for now.
            }
            user.setGender((String)userInput.get(GENDER));
            return user;
        } else {
            throw new HTTPException(Http.Status.BAD_REQUEST);
        }
    }

    private boolean validateUserInput(Map<String, Object> userInput) {
        return (userInput.containsKey(FIRST_NAME) && userInput.containsKey(LAST_NAME)
                && userInput.containsKey(USER_NAME) && userInput.containsKey(PASSWORD)
                && userInput.containsKey(EMAIL) && userInput.containsKey(DOB)
                && userInput.containsKey(GENDER));
    }
}
