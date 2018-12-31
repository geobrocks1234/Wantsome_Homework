package week5.NuclearReactor;

import java.util.concurrent.ThreadLocalRandom;

public class Reactor {
    private int criticalOutput;
    private int output;

    public Reactor(int criticalOutput){
        this.criticalOutput = criticalOutput;
        this.output = 0;
    }

    public int getOutput() { return output; }

    public int getCriticalOutput() { return criticalOutput; }

    private void setOutput ( int output ) { this.output = output; }

    public void increase(){
        int increased = ThreadLocalRandom.current().nextInt(1,100);
        if(getOutput ()+increased > getCriticalOutput ()){
            throw new ReactorException ("Danger! The reactor is going critical!");
        }
        setOutput ( getOutput () + increased );
        System.out.println("The reactor's output level was increased by: " + increased + " units.");
    }

    public void decrease(){
        int decreased = ThreadLocalRandom.current().nextInt(1,100);
        setOutput ( getOutput () - decreased );
        if(getOutput ()<0) { setOutput ( 0 ); }
        System.out.println("The reactor's output level was decreased by: " + decreased + " units.");
    }
}
