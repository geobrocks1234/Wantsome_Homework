package week5.SensorAndMeasurement;

public class ConstantSensor implements Sensor {

    private int dim;

    public ConstantSensor(int dimension) {
        this.dim = dimension;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void on() {
        System.out.println("Sensor is ON!");
    }

    @Override
    public void off() {
        System.out.println("Sensor cannot be switched OFF!");
    }

    @Override
    public int measure() {
        return dim;
    }
}