package abstract_factory_method;

public abstract class Button {
    protected String text;

    public Button(String text) {
        this.text = text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    public abstract void display();
}
