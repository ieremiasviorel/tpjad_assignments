package models;

import io.ebean.Finder;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FileItem extends FileManagerItem {

    public String extension;

    public FileItem(String name, DirectoryItem parent) {
        super(name, parent);
    }

    public static final Finder<Long, FileItem> find = new Finder<Long, FileItem>(FileItem.class);

    public static FileItem getById(final Long id) {
        return find.byId(id);
    }
}
