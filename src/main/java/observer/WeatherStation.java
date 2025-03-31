package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements WeatherObservable, Runnable {

    private final List<WeatherObserver> observers = new ArrayList<>();
    private float temperature;
    private final Random random = new Random();
    private final float MIN_TEMP = -50.0f;
    private final float MAX_TEMP = 50.0f;

    public WeatherStation() {
        this.temperature = MIN_TEMP + random.nextFloat() * (MAX_TEMP - MIN_TEMP);
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                int sleepTime = 1000 + random.nextInt(4000);
                Thread.sleep(sleepTime);

                float change = random.nextBoolean() ? 1.0f : -1.0f;
                float newTemp = temperature + change;

                if (newTemp >= MIN_TEMP && newTemp <= MAX_TEMP){
                    temperature = Math.round(newTemp);
                    System.out.println("Weather station: new temperature = " + temperature);
                    notifyObservers();
                }
            } catch (InterruptedException e) {
                System.out.println("Weather station is not working.");
                break;
            }
        }
    }
}
