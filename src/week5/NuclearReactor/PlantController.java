package week5.NuclearReactor;

public class PlantController {
    private PowerPlant powerPlant;
    private Reactor reactor;

    public PlantController(PowerPlant powerPlant, Reactor reactor){
        this.powerPlant = powerPlant;
        this.reactor = reactor;
    }

    public boolean needAdjustment(){
        System.out.println("The difference between reactor output and plant desired output differs by a value: " + ( powerPlant.getOutput() - reactor.getOutput ()) + " units.");
        return powerPlant.getOutput() - reactor.getOutput () > 10;
    }

    public void adjust(){
        while(needAdjustment()){
            reactor.increase();
        }
        System.out.println("The reactor output level was adjusted.");
    }

    public void shutdown(){
        while(reactor.getOutput()!=0){
            reactor.decrease();
        }
        System.out.println ("The reactor was shut down properly.");
    }

    public void run(){
        try {
            while(needAdjustment()) {
                adjust();
            }
        } catch(ReactorException e) {
            powerPlant.soundAlert ();
            System.out.println("The reactor is shutting down due to a critical event.");
            shutdown();
        }
    }
}
