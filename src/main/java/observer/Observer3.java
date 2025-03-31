package observer;

public class Observer3 implements WeatherObserver {
    @Override
    public void update(float temperature) {
        System.out.println("⚡ Observer3: Weather update -> " + temperature + "°C");
    }
}