package week5.SensorAndMeasurement;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{

    private List<Sensor> sensors;

    public AverageSensor(){
        sensors = new ArrayList<>();
    }

    public void addSensor(Sensor sensor){
        sensors.add(sensor);
    }

    @Override
    public boolean isOn() {
        for(Sensor sensor: sensors){
            if(!sensor.isOn()) { return false; }
        }
        return true;
    }

    @Override
    public void on() {
        for(Sensor sensor:sensors){
            if(!sensor.isOn()){ sensor.on(); }
        }
    }

    @Override
    public void off() {
        for(Sensor sensor: sensors){
            if(sensor.isOn()){ sensor.off(); }
        }
    }

    @Override
    public int measure() {
        if(!isOn()) { throw new SensorException("The average sensor is OFF!"); }
        if(sensors.isEmpty()) { throw new SensorException("The average sensor has no registered sensors."); }
        int average = 0;
        for(Sensor sensor : sensors) {
            average += sensor.measure();
        }
        return average / sensors.size();
    }
}
