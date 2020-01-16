package controllers;

import com.feth.play.module.pa.PlayAuthenticate;
import models.DirectoryItem;
import models.FileItem;
import models.LinkedAccount;
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

    public boolean checkUserPermission(Long directoryId) {
        final User localUser = this.userService.getLocalUser(this.auth.getUser(session()));
        final DirectoryItem directory = DirectoryItem.getById(directoryId);
        final LinkedAccount account = localUser.getAccountByProvider("google");

        // check if the user owns the directory
        return account.rootDirectory.id == directory.getRoot().id;
    }

    public Result index() {
        final User localUser = this.userService.getLocalUser(this.auth.getUser(session()));
        return redirect("restricted/" + localUser.linkedAccounts.get(0).rootDirectory.id.toString());
    }

    public Result indexById(String directoryId) {
        final User localUser = this.userService.getLocalUser(this.auth.getUser(session()));
        final DirectoryItem directory = DirectoryItem.getById(Long.parseLong(directoryId));

        if (!checkUserPermission(directory.id)) {
            return unauthorized();
        }

        final List<DirectoryItem> directoryAncestors = directory.getAncestors();

        return ok(restricted.render(this.auth, localUser, directory, directoryAncestors));
    }

    public Result download(String fileIdStr) {
        Long fileId = Long.parseLong(fileIdStr);

        FileItem fileItem = FileItem.getById(fileId);

        if (!checkUserPermission(fileItem.parent.id)) {
            return unauthorized();
        }

        String filePath = FileService.getFilePath(fileItem);
        File file = FileService.downloadFile(filePath);

        response().setHeader("Content-disposition", "attachment; filename=\"" + fileItem.name + "\"");
        return ok(file);
    }

    public Result upload(String directoryIdStr) {
        DirectoryItem directoryItem = DirectoryItem.getById(Long.parseLong(directoryIdStr));

        if (!checkUserPermission(directoryItem.id)) {
            return unauthorized();
        }

        Http.MultipartFormData data = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart filePart = data.getFile("file");

        File file = (File) filePart.getFile();
        String fileName = filePart.getFilename();

        if (!FileService.uploadFile(file, fileName, Long.parseLong(directoryIdStr))) {
            System.err.println("Error uploading fileȘ " + fileName);
        }

        return redirect("/restricted/" + directoryIdStr);
    }
}