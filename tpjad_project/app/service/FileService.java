package service;

import models.FileItem;

import java.io.File;

public class FileService {
    public static final String USER_DIRECTORY = "userdata";

    public static String computeFilePath(FileItem fileItem) {
        return USER_DIRECTORY + "/" + fileItem.id + "." + fileItem.extension;
    }

    public static String computeFileName(FileItem fileItem) {
        return fileItem.name + "." + fileItem.extension;
    }

    public static File downloadFile(String path) {
        return new File(path);
    }
}
