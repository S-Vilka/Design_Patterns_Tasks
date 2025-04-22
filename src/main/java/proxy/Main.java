package proxy;

public class Main {
    public static void main(String[] args) {

        User alice = new User("alice");
        User mikko = new User("mikko");
        User pekka = new User("pekka");

        Library library = new Library();

        library.addUnprotectedDocument("doc1", "This is an unprotected document.");
        library.addProtectedDocument("protected1", "This is a PROTECTED document.", new String[]{"mikko"});
        library.addProtectedDocument("protected2", "This is also a PROTECTED document", new String[]{"pekka"});


        try {
            System.out.println("Alice reads doc1: " + library.getDocument("doc1").getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
        }

        try {
            System.out.println("Mikko reads protected1: " + library.getDocument("protected1").getContent(mikko));
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
        }

        try {
            System.out.println("Alice tries to read protected1: " + library.getDocument("protected1").getContent(alice));
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
        }

        try {
            System.out.println("Pekka reads protected2: " + library.getDocument("protected2").getContent(pekka));
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
        }

        try {
            System.out.println("Mikko tries to read protected2: " + library.getDocument("protected2").getContent(mikko));
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
        }
    }
}