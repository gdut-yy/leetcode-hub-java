package p1825;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1825D2Tests extends AbstractOjTests {
    public CF1825D2Tests() {
        super("/p1825/D2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1825D2.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1825D2.main(null);
        super.doAssertion(OUTPUT2);
    }
}