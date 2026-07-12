package p2165;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2165CTests extends AbstractOjTests {
    public CF2165CTests() {
        super("/p2165/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2165C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
