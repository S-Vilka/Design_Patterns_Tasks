package prototype;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Recommendation> recommendations = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> viewAllRecommendations();
                case "2" -> createNewRecommendation();
                case "3" -> cloneAndModifyRecommendation();
                case "4" -> {
                    System.out.println("\nGoodbye! Thank you for using the book recommendation system.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nBook Recommendation System");
        System.out.println("1. View all recommendations");
        System.out.println("2. Create a new recommendation from scratch");
        System.out.println("3. Clone and modify an existing recommendation");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }

    private static void viewAllRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("There are currently no recommendations.");
            return;
        }
        recommendations.forEach((name, rec) -> {
            System.out.println("\n--- Recommendation: " + name + " ---");
            System.out.println(rec);
        });
    }

    private static void createNewRecommendation() {
        System.out.print("Enter a name for the new recommendation: ");
        String name = scanner.nextLine().trim();

        if (recommendations.containsKey(name)) {
            System.out.println("A recommendation with this name already exists.");
            return;
        }

        System.out.print("Enter the target audience: ");
        String audience = scanner.nextLine().trim();
        Recommendation rec = new Recommendation(audience);

        boolean addingBooks = true;

        while (addingBooks) {
            System.out.print("Do you want to add a book? (y/n): ");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("y")) {
                rec.addBook(createBookFromInput());
            } else if (answer.equalsIgnoreCase("n")) {
                addingBooks = false;
            } else {
                System.out.println("Please enter 'y' or 'n'.");
            }
        }

        recommendations.put(name, rec);
        System.out.println("New recommendation \"" + name + "\" has been created.");
    }

    private static void cloneAndModifyRecommendation() {
        System.out.print("Enter the name of the recommendation to clone: ");
        String originalName = scanner.nextLine().trim();
        Recommendation original = recommendations.get(originalName);

        if (original == null) {
            System.out.println("Recommendation not found.");
            return;
        }

        Recommendation cloned = original.clone();

        System.out.print("Enter a new name for the cloned recommendation: ");
        String newName = scanner.nextLine().trim();

        if (recommendations.containsKey(newName)) {
            System.out.println("A recommendation with this name already exists.");
            return;
        }

        System.out.print("Change the target audience? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            System.out.print("Enter the new target audience: ");
            cloned.setTargetAudience(scanner.nextLine().trim());
        }

        while (true) {
            System.out.println("\nModify the book list:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book by title");
            System.out.println("3. Finish editing");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().trim();
            if (input.equals("1")) {
                cloned.addBook(createBookFromInput());
            } else if (input.equals("2")) {
                System.out.print("Enter the title of the book to remove: ");
                cloned.removeBookByTitle(scanner.nextLine().trim());
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

        recommendations.put(newName, cloned);
        System.out.println("Cloned and modified recommendation \"" + newName + "\" has been saved.");
    }

    private static Book createBookFromInput() {
        System.out.println("\nEnter book details:");
        System.out.print("Author: ");
        String author = scanner.nextLine().trim();
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Genre: ");
        String genre = scanner.nextLine().trim();
        System.out.print("Publication year: ");
        int year = Integer.parseInt(scanner.nextLine().trim());

        return new Book(author, title, genre, year);
    }
}