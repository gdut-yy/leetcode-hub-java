package p2070;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2070CTests extends AbstractOjTests {
    public CF2070CTests() {
        super("/p2070/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2070C.main(null);
        super.doAssertion(OUTPUT1);
    }
}