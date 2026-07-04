package c015;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Agc015cTests extends AbstractOjTests {
    public Agc015cTests() {
        super("/c015/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Agc015_c.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Agc015_c.main(null);
        super.doAssertion(OUTPUT2);
    }
}
