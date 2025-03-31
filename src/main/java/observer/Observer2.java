package observer;

public class Observer2 implements WeatherObserver {
    @Override
    public void update(float temperature) {
        System.out.println("📈 Observer2: New temperature: " + temperature + "°C.");
    }
}