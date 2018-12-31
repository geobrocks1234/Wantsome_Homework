package NuclearReactor;

import org.junit.Assert;
import org.junit.Test;
import week5.NuclearReactor.PlantController;
import week5.NuclearReactor.PowerPlant;
import week5.NuclearReactor.Reactor;

import static org.junit.Assert.assertTrue;

public class PlantControllerTest {

    @Test
    public void testThatNeedAdjustmentMethodReturnsTrueWhenDifferenceIsBiggerThanTenOrLessThanZero(){
        PowerPlant powerPlant = new PowerPlant(20);
        Reactor reactor = new Reactor(100);
        PlantController plantController = new PlantController(powerPlant, reactor);
        assertTrue(plantController.needAdjustment());
    }

    @Test
    public void testThatAdjustMethodIncreaseTheReactorOutputLevel() {
        PowerPlant powerPlant = new PowerPlant(20);
        Reactor reactor = new Reactor(100);
        PlantController plantController = new PlantController(powerPlant, reactor);
        while(plantController.needAdjustment()) {
            plantController.adjust();
            if(reactor.getOutput () > 20){
                break;
            }
        }
        Assert.assertFalse ( plantController.needAdjustment () );
    }

    @Test
    public void testThatShutDownMethodDecreaseTheReactorOutputLevel() {
        PowerPlant powerPlant = new PowerPlant(20);
        Reactor reactor = new Reactor(100);
        PlantController plantController = new PlantController(powerPlant, reactor);
        plantController.adjust();
        while(reactor.getOutput ()!=0) {
            plantController.shutdown ();
        }
        Assert.assertTrue ( plantController.needAdjustment () );
    }
}
