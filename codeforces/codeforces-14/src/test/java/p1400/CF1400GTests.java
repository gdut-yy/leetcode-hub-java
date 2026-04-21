package p1400;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1400GTests extends AbstractOjTests {
    public CF1400GTests() {
        super("/p1400/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1400G.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1400G.main(null);
        super.doAssertion(OUTPUT2);
    }
}