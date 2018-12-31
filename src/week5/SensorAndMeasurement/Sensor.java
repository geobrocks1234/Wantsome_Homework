package week5.SensorAndMeasurement;

public interface Sensor
{
    //returns true if the sensor is on
    boolean isOn();

    //switches the sensor on
    void on();

    //switches the sensor off
    void off();

    //returns the sensor reading if the sensor is on,
    //or throws and exception if the sensor is off
    int measure();
}