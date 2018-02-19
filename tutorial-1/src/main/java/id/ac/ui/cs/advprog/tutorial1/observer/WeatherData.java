package id.ac.ui.cs.advprog.tutorial1.observer;

import java.util.Observable;

public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity,
                                float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        // TODO Complete me!
        return temperature;
    }

    public void setTemperature(float temperature) {
        // TODO Complete me!
        this.temperature = temperature;
    }

    public float getHumidity() {
        // TODO Complete me!
        return humidity;
    }

    public void setHumidity(float humidity) {
        // TODO Complete me!
        this.humidity = humidity;
    }

    public float getPressure() {
        // TODO Complete me!
        return pressure;
    }

    public void setPressure(float pressure) {
        // TODO Complete me!
        this.pressure = pressure;
    }
}
