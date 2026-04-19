package p2118;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2118CTests extends AbstractOjTests {
    public CF2118CTests() {
        super("/p2118/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2118C.main(null);
        super.doAssertion(OUTPUT1);
    }
}