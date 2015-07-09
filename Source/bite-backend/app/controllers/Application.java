package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import play.Play;
import play.libs.Json;
import play.mvc.*;

import services.IUserService;
import views.html.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Application extends Controller {
    @Autowired
    private IUserService usrService;

    public Result index() {
        return play.mvc.Controller.ok(index.render("Hello World"));
    }

    //pre-flight method to set right access for pre-flight requests
    public static Result preflight(String all) {
        response().setHeader("Access-Control-Allow-Origin", Play.application().configuration().getString("header.allowableDomains"));
        response().setHeader("Allow", Play.application().configuration().getString("header.allowableMethodsPreFlight"));
        response().setHeader("Access-Control-Allow-Methods", Play.application().configuration().getString("header.allowableMethods"));
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        return ok();
    }
}
