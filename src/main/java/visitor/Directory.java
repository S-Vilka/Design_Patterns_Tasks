package visitor;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addElement(FileSystemElement element) {
        children.add(element);
    }

    public List<FileSystemElement> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement element : children) {
            element.accept(visitor);
        }
    }
}
