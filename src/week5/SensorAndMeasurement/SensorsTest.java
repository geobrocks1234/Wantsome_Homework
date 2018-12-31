package week5.SensorAndMeasurement;

public class SensorsTest {
    public static void main(String[] args) {
        Sensor cs1 = new ConstantSensor(12);
        Sensor cs2 = new ConstantSensor(24);
        Sensor cs3 = new ConstantSensor(33);

        System.out.println("Constant sensor measurement: " + cs1.measure());
        System.out.println("Sensor is ON: " + cs1.isOn());
        System.out.println("Sensor is switch OFF.");
        cs1.off();
        System.out.println("Sensor is ON: " + cs1.isOn());

        Sensor t1 = new ThermometerSensor();
        Sensor t2 = new ThermometerSensor();
        Sensor t3 = new ThermometerSensor();

        try {
            System.out.println("The second thermometer measures: " + t2.measure());
        } catch(SensorException e){
            System.out.println(e.getMessage());
        }

        AverageSensor as1 = new AverageSensor();
        as1.addSensor(cs1);
        as1.addSensor(cs2);
        as1.addSensor(cs3);
        as1.addSensor(t1);
        as1.addSensor(t2);
        as1.addSensor(t3);

        try {
            System.out.println ( "The first average sensor measurement: " + as1.measure () );
        } catch(SensorException e){
            System.out.println(e.getMessage());
        }

        t2.on();

        try {
            System.out.println ( "The first sensor measurement: " + as1.measure () );
        } catch (SensorException e){
            System.out.println(e.getMessage());
        }

        AverageSensor as2 = new AverageSensor();
        try {
            System.out.println ( "The second average sensor measurement: " + as2.measure () );
        } catch (SensorException e){
            System.out.println(e.getMessage());
        }

        AverageSensor as3 = new AverageSensor();
        as3.addSensor ( t2 );
        try {
            System.out.println ( "The third average sensor measurement: " + as3.measure () );
        } catch (SensorException e){
            System.out.println(e.getMessage());
        }
    }
}
