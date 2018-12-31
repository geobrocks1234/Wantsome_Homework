package NuclearReactor;

import org.junit.Test;
import week5.NuclearReactor.Reactor;
import week5.NuclearReactor.ReactorException;

import static org.junit.Assert.assertTrue;

public class ReactorTest {

    @Test
    public void testThatIncreaseMethodIncrementTheOutput(){
        Reactor reactor = new Reactor(100);
        int out1 = reactor.getOutput();
        reactor.increase();
        int out2 = reactor.getOutput();
        assertTrue(out2-out1>0);
    }

    @Test(expected = ReactorException.class)
    public void testThatExceptionIsThrownWhenCriticalOutputIsOccurred(){
        Reactor reactor = new Reactor(0);
        reactor.increase();
    }
}