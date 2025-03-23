package abstract_factory_method;

public abstract class UIFactory {

    public abstract Button createButton(String text);

    public abstract TextField createTextField(String text);

    public abstract Checkbox createCheckbox (String text);
}
