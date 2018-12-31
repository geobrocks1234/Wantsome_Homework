package SensorAndMeasurement;

import org.junit.Test;
import week5.SensorAndMeasurement.Sensor;
import week5.SensorAndMeasurement.SensorException;
import week5.SensorAndMeasurement.ThermometerSensor;
import static org.junit.Assert.*;

public class ThermometerSensorTest {

    @Test
    public void testThatThermometerIsInitiatingByOff(){
        Sensor t = new ThermometerSensor();
        assertFalse(t.isOn());
    }

    @Test
    public void testThatThermometerIsSwitchedOn(){
        Sensor t = new ThermometerSensor();
        t.on();
        assertTrue(t.isOn ());
    }

    @Test
    public void testThatThermometerIsSwitchedOff(){
        Sensor t = new ThermometerSensor();
        t.on();
        t.off();
        assertFalse(t.isOn ());
    }

    @Test(expected = SensorException.class)
    public void testThermometerOffThrowsSensorException(){
        Sensor t = new ThermometerSensor();
        t.measure();
    }

    @Test
    public void testThatThermometerMeasuresRandomValues(){
        Sensor t = new ThermometerSensor();
        t.on();
        int m1 = t.measure();
        int m2 = t.measure();
        assertNotEquals(m1,m2);
    }

}
