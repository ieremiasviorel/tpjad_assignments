package models;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class FileManagerItem extends AppModel {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    public String name;

    public String path;

    @ManyToOne(optional = true)
    public DirectoryItem parent;

    public FileManagerItem(String name, DirectoryItem parent) {
        this.name = name;
        this.parent = parent;
        this.path = computePath();
    }

    public String computePath() {
        List<DirectoryItem> ancestors = getAncestors();

        Optional<String> pathOptional = ancestors.stream()
                .map(d -> d.name)
                .reduce((acc, curr) -> acc + "/" + curr);

        return pathOptional.orElse("");
    }

    public List<DirectoryItem> getAncestors() {
        List<DirectoryItem> ancestors = new ArrayList<>();

        DirectoryItem current = parent;
        while (current != null) {
            ancestors.add(0, current);
            current = current.parent;
        }

        return ancestors;
    }
}
