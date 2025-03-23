package abstract_factory_method;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UIFactory factory = new FactoryA();
        //UIFactory factory = new FactoryB();

        Button button = factory.createButton("Submit");
        TextField textField = factory.createTextField("Username");
        Checkbox checkbox = factory.createCheckbox("I agree to terms");

        System.out.println("Initial UI:");
        button.display();
        textField.display();
        checkbox.display();

        System.out.println("\n--- Update UI ---");

        System.out.print("Enter new text for the button: ");
        String newButtonText = scanner.nextLine();
        button.setText(newButtonText);

        System.out.print("Enter new text for the text field: ");
        String newTextFieldText = scanner.nextLine();
        textField.setText(newTextFieldText);

        System.out.print("Enter new text for the checkbox: ");
        String newCheckboxText = scanner.nextLine();
        checkbox.setText(newCheckboxText);

        System.out.println("\nUpdated UI:");
        button.display();
        textField.display();
        checkbox.display();

    }
}
