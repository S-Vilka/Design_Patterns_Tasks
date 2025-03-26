package composite;

public class Main {
    public static void main(String[] args) {

        OrganisationComponent employee1 = new Employee("Mike", 3000);
        OrganisationComponent employee2 = new Employee("Walter", 4000);
        OrganisationComponent employee3 = new Employee("Jesse", 5000);

        Department devDept = new Department("Chemistry");
        devDept.add(employee2);
        devDept.add(employee3);

        Department itDept = new Department("IT");
        itDept.add(employee1);
        itDept.add(devDept);

        System.out.println("== Total dept. salary ==");
        System.out.println(itDept.getSalary());

        System.out.println("== XML ==");
        System.out.println(itDept.toXml());
    }
}
