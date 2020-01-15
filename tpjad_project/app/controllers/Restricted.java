package controllers;

import com.feth.play.module.pa.PlayAuthenticate;
import models.DirectoryItem;
import models.FileItem;
import models.User;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import service.FileService;
import service.UserService;
import views.html.restricted;

import javax.inject.Inject;
import java.io.File;
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
        final DirectoryItem directory = DirectoryItem.getById(Long.parseLong(directoryId));
        final List<DirectoryItem> directoryAncestors = directory.getAncestors();

        return ok(restricted.render(this.auth, localUser, directory, directoryAncestors));
    }

    public Result download(String fileId) {
        Long id = Long.parseLong(fileId);

        FileItem fileItem = FileItem.getById(id);

        String fileName = FileService.computeFileName(fileItem);
        String filePath = FileService.computeFilePath(fileItem);

        File file = FileService.downloadFile(filePath);

        response().setContentType("application/x-download");
        response().setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
        return ok(file);
    }

    public Result upload(String directoryId) {
        Http.MultipartFormData data = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart filePart = data.getFile("file");

        File file = (File) filePart.getFile();
        String fileName = filePart.getFilename();

        if (!FileService.uploadFile(file, fileName, directoryId)) {
            //exception
            System.out.println("TODO");
        }

        return redirect("/restricted/" + directoryId);
    }
}
