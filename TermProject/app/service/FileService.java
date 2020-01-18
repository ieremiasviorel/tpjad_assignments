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

        return file.renameTo(new File(FileService.USER_DIRECTORY + "/" + hash(fileItem.id)));
    }

    public static String getFilePath(FileItem fileItem) {
        return USER_DIRECTORY + "/" + hash(fileItem.id);
    }

    public static void deleteFile(FileItem fileItem) {
        String path = getFilePath(fileItem);
        File file = new File(path);
        if (file.delete()) {
            fileItem.delete();
        }
    }

    private static String hash(Long id) {
        return String.valueOf((id.toString() + "secret").hashCode());
    }
}
