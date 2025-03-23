package abstract_factory_method;

public class FactoryA  extends UIFactory {
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
}
