package abstract_factory_method;

public class ButtonB extends Button {

    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        String content = "|<< " + text + " >> |";
        int width = content.length();
        String border = "*" + "=".repeat(width - 2) + "*";

        System.out.println(border);
        System.out.println(content);
        System.out.println(border);
    }
}