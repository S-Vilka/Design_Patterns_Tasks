package abstract_factory_method;

public abstract class Checkbox {
    protected String text;

    public Checkbox(String text) {
        this.text = text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    public abstract void display();
}
