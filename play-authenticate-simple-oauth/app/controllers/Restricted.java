package controllers;

import com.feth.play.module.pa.PlayAuthenticate;
import models.DirectoryItem;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import service.UserService;
import views.html.restricted;

import javax.inject.Inject;
import java.util.List;

@Security.Authenticated(Secured.class)
public class Restricted extends Controller {

    private final PlayAuthenticate auth;
    private final UserService userService;

    @Inject
    public Restricted(final PlayAuthenticate auth, final UserService userService) {
        this.auth = auth;
        this.userService = userService;
    }

    public Result index() {
        final User localUser = this.userService.getLocalUser(this.auth.getUser(session()));
        return redirect("restricted/" + localUser.linkedAccounts.get(0).rootDirectory.id.toString());
    }

    public Result indexById(String directoryId) {
        final User localUser = this.userService.getLocalUser(this.auth.getUser(session()));
        System.out.println(directoryId);
        final DirectoryItem directory = DirectoryItem.getById(Long.parseLong(directoryId));
        final List<DirectoryItem> directoryAncestors = directory.getAncestors();

        return ok(restricted.render(this.auth, localUser, directory, directoryAncestors));
    }
}
