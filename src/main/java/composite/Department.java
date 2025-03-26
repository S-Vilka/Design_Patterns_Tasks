package composite;

// Composite object - stores employees. May store other departments. Returns total salary of all employees in the department

import java.util.ArrayList;
import java.util.List;

public class Department implements OrganisationComponent {
    private String name;
    private List<OrganisationComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public void add(OrganisationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganisationComponent component) {
        components.remove(component);
    }

    @Override
    public int getSalary() {
        int total = 0;
        for (OrganisationComponent component : components) {
            total += component.getSalary();
        }
        return total;
    }

    @Override
    public String toXml() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("<department name=\"%s\">", name));
        for (OrganisationComponent component : components) {
            builder.append("\n ").append(component.toXml());
        }
        builder.append("\n</department>");
        return builder.toString();

    }
}
