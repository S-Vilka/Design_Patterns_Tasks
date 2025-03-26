package composite;

//Employee is a leaf. It does not contain other objects, just stored name & salary data

public class Employee implements OrganisationComponent {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public String toXml() {
        return String.format("<employee name=\"%s\" salary=\"%d\" />", name, salary);
    }
}
