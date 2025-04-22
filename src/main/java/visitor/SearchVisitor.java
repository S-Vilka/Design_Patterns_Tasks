package visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String pattern;
    private List<File> foundFiles = new ArrayList<>();

    public SearchVisitor(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(pattern)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
