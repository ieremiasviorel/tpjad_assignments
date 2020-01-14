package models;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FileItem extends FileManagerItem {

    private static final long serialVersionUID = 1L;

    public String dataId;

    public String extension;

    public FileItem(String name, DirectoryItem parent) {
        super(name, parent);
    }
}
