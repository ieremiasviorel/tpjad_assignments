package service;

import models.DirectoryItem;
import models.FileItem;

import java.io.File;

public class FileService {
    public static final String USER_DIRECTORY = "userdata";

    public static File downloadFile(String path) {
        return new File(path);
    }

    private static String hash(Long id) {
        return String.valueOf((id.toString() + "secret").hashCode());
    }

    public static boolean uploadFile(File file, String fileName, Long directoryId) {
        FileItem fileItem = new FileItem(fileName, DirectoryItem.getById(directoryId));
        fileItem.save();

        System.out.println(hash(fileItem.id));

        return file.renameTo(new File(FileService.USER_DIRECTORY + "/" + hash(fileItem.id)));
    }

    public static String getFilePath(FileItem fileItem) {
        return USER_DIRECTORY + "/" + hash(fileItem.id);
    }
}
