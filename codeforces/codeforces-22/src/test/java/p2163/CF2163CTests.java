package p2163;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2163CTests extends AbstractOjTests {
    public CF2163CTests() {
        super("/p2163/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2163C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
