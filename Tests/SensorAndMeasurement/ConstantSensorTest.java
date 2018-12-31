package SensorAndMeasurement;

import org.junit.Test;
import week5.SensorAndMeasurement.ConstantSensor;
import week5.SensorAndMeasurement.Sensor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConstantSensorTest {

    @Test
    public void testThatConstantSensorIsInitiatingByOn(){
        Sensor c = new ConstantSensor (1);
        assertTrue(c.isOn ());
    }

    @Test
    public void testThatConstantSensorIsOnAfterSwitchingOff(){
        Sensor c = new ConstantSensor(1);
        c.off ();
        assertTrue(c.isOn ());
    }

    @Test
    public void testSensorMeasurement(){
        Sensor c = new ConstantSensor(1);

        assertEquals(1, c.measure ());
    }
}