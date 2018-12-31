package week5.NuclearReactor;

public class NuclearReactorTest {
    public static void main(String[] args) {

        PowerPlant powerPlant = new PowerPlant(120);
        Reactor reactor = new Reactor(150);

        PlantController plantController = new PlantController(powerPlant, reactor);

        plantController.run();
    }
}
