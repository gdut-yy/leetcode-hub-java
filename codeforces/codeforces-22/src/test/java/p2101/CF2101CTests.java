package p2101;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2101CTests extends AbstractOjTests {
    public CF2101CTests() {
        super("/p2101/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2101C.main(null);
        super.doAssertion(OUTPUT1);
    }
}