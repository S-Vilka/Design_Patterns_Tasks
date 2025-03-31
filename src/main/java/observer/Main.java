package observer;

public class Main {
    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        Observer3 observer3 = new Observer3();

        station.addObserver(observer1);
        station.addObserver(observer2);
        station.addObserver(observer3);

        Thread thread = new Thread(station);
        thread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n Observer2 deleted \n");
        station.removeObserver(observer2);

    }
}
