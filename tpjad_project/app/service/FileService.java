package service;

import models.DirectoryItem;
import models.FileItem;

import java.io.File;

public class FileService {
    public static final String USER_DIRECTORY = "userdata";

    public static File downloadFile(String path) {
        return new File(path);
    }

    public static boolean uploadFile(File file, String fileName, Long directoryId) {
        FileItem fileItem = new FileItem(fileName, DirectoryItem.getById(directoryId));
        fileItem.save();

        return file.renameTo(new File(FileService.USER_DIRECTORY + "/" + fileItem.id));
    }

    public static String getFilePath(FileItem fileItem) {
        return USER_DIRECTORY + "/" + fileItem.id;
    }
}
