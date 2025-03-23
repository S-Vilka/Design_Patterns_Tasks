package abstract_factory_method;

public class ButtonA extends Button {

    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        String content = "|  " + text + "  |";
        String line = "+" + "-".repeat(content.length() - 2) + "+";

        System.out.println(line);
        System.out.println(content);
        System.out.println(line);
    }
}