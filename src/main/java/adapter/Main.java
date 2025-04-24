package adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface myDate = new CalendarToNewDateAdapter();

        myDate.setYear(2025);
        myDate.setMonth(4);
        myDate.setDay(23);

        System.out.println("Current date: " + myDate.getDay() + "." + myDate.getMonth() + "." + myDate.getYear());

        myDate.advanceDays(10);

        System.out.println("New date: " + myDate.getDay() + "." + myDate.getMonth() + "." + myDate.getYear());
    }
}
