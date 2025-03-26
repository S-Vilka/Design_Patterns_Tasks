package composite;

public interface OrganisationComponent {

    int getSalary();

    String toXml();

    //used only by departments
    default void add(OrganisationComponent component) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    //used only by departments
    default void remove(OrganisationComponent component) {
        throw new UnsupportedOperationException("Operation not supported");
    }
}
