package observer;

public class Observer1 implements WeatherObserver {
    @Override
    public void update(float temperature) {
        System.out.println("🌡️ Observer1: Temperature change detected. Current temp: " + temperature + "°C");
    }
}