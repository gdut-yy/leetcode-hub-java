package p2064;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2064CTests extends AbstractOjTests {
    public CF2064CTests() {
        super("/p2064/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2064C.main(null);
        super.doAssertion(OUTPUT1);
    }
}