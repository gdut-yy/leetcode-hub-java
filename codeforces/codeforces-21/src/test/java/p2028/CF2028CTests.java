package p2028;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2028CTests extends AbstractOjTests {
    public CF2028CTests() {
        super("/p2028/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2028C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
