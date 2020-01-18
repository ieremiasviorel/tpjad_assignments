package service;

import models.DirectoryItem;
import models.FileItem;

public class DirectoryService {

    public static void deleteDirectory(DirectoryItem directoryItem) {
        directoryItem.childrenFiles.forEach(c -> FileService.deleteFile(FileItem.getById(c.id)));

        directoryItem.childrenDirectories.forEach(d -> deleteDirectory(DirectoryItem.getById(d.id)));

        directoryItem.delete();
    }
}
