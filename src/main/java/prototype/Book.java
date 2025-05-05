package prototype;

public class Book implements Cloneable {
    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone(); // shallow copy
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + genre + ", " + publicationYear + ")";
    }

    public String getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getPublicationYear() { return publicationYear; }
}
