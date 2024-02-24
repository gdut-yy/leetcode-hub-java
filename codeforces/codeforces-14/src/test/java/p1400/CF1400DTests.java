package p1400;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1400DTests extends AbstractOjTests {
    public CF1400DTests() {
        super("/p1400/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1400D.main(null);
        super.doAssertion(OUTPUT1);
    }
}