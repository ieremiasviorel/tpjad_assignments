package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class HelloWorld extends Controller {

    public Result index(String name) {
        return ok("Hello " + name + "!");
    }

    public Result indexWithPathParam(String name) {
        return ok("Hello " + name + "!");
    }

    public Result indexWithPathParamAndQueryParam(String title, String name) {
        return ok("Hello " + title + ". " + name + "!");
    }

    public Result indexWithHTML(String title, String name) {
        return ok(views.html.hello.render(title, name));
    }
}
