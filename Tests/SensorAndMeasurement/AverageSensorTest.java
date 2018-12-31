package SensorAndMeasurement;

import org.junit.Test;
import week5.SensorAndMeasurement.*;

public class AverageSensorTest {

    @Test(expected = SensorException.class)
    public void testThatAverageSensorsClassWithSensorsRegisteredThrowsSensorException (){
        Sensor cs1 = new ConstantSensor (12);
        Sensor cs2 = new ConstantSensor(23);
        Sensor t1 = new ThermometerSensor ();

        AverageSensor as = new AverageSensor ();
        as.addSensor(cs1);
        as.addSensor(cs2);
        as.addSensor(t1);
        as.measure();
    }

    @Test(expected = SensorException.class)
    public void testThatAverageSensorsClassWithNoSensorsRegisteredThrowsSensorException () {
        AverageSensor a1 = new AverageSensor();
        a1.measure();
    }
}