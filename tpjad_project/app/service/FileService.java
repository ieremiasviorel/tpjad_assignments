package service;

import javafx.util.Pair;
import models.DirectoryItem;
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

    private static Pair<String, String> getFileNameAndExtension(String fullName) {
        int extensionIdx = fullName.lastIndexOf(".");
        String fileName, fileExtension;
        if (extensionIdx != -1) {
            fileName = fullName.substring(0, extensionIdx);
            fileExtension = fullName.substring(extensionIdx + 1);
        } else {
            fileName = fullName;
            fileExtension = "";
        }
        return new Pair<>(fileName, fileExtension);
    }

    public static boolean uploadFile(File file, String fullName, String directoryId) {
        Pair<String, String> fileNameAndExtension = getFileNameAndExtension(fullName);

        FileItem fileItem = new FileItem(
                fileNameAndExtension.getKey(),
                DirectoryItem.getById(Long.parseLong(directoryId)),
                fileNameAndExtension.getValue());

        fileItem.save();

        return file.renameTo(new File(FileService.USER_DIRECTORY + "/" + fileItem.id));
    }
}
