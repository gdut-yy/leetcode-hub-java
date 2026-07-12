package p2119;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2119CTests extends AbstractOjTests {
    public CF2119CTests() {
        super("/p2119/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2119C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
