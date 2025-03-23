package abstract_factory_method;

public abstract class TextField {
    protected String text;

    public TextField(String text) {
        this.text = text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    public abstract void display();
}
