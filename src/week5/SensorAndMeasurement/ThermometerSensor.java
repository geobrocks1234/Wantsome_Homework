package week5.SensorAndMeasurement;

import java.util.concurrent.ThreadLocalRandom;

public class ThermometerSensor implements Sensor {
    private boolean isOn;

    public ThermometerSensor(){
        isOn = false;
    }

    private void setOn ( boolean on ) {
        isOn = on;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void on() {
        if(!isOn ){
            setOn(true);
            System.out.println("Thermometer was switched ON!");
        } else { System.out.println("Thermometer is already ON!"); }
    }

    @Override
    public void off() {
        if( isOn ) {
            setOn(false);
            System.out.println("Thermometer was switched OFF!");
        } else { System.out.println("Thermometer is already OFF!"); }
    }

    @Override
    public int measure() {
        if(!isOn ) {
            throw new SensorException("Thermometer is OFF!");
        }
        return ThreadLocalRandom.current().nextInt(-30,30);
    }
}
