package visitor;

public class Main {
    public static void main(String[] args) {

        Directory root = new Directory("root");
        File file1 = new File("assignment.pdf", 3);
        File file2 = new File("sampleData.svg", 5);
        Directory subDir = new Directory("photos");
        File file3 = new File("photo.jpg", 25);
        File file4 = new File("123.png", 10);

        root.addElement(file1);
        root.addElement(file2);
        root.addElement(subDir);
        subDir.addElement(file3);
        subDir.addElement(file4);

        // Size calculation
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        // File search
        SearchVisitor searchVisitor = new SearchVisitor(".jpg");
        root.accept(searchVisitor);
        System.out.println("Files matching:");
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println("- " + file.getName());
        }
    }
}
