package controllers;

import play.Play;
import play.mvc.*;

public class Application extends Controller {

    public Result index() {
        return ok("Loaded!");
    }

    //pre-flight method to set right access for pre-flight requests
    public Result preFlight(String all) {
        response().setHeader("Access-Control-Allow-Origin", Play.application().configuration().getString("header.allowableDomains"));
        response().setHeader("Allow", Play.application().configuration().getString("header.allowableMethodsPreFlight"));
        response().setHeader("Access-Control-Allow-Methods", Play.application().configuration().getString("header.allowableMethods"));
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        return ok();
    }

}
