package p1466;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF1466CTests extends AbstractOjTests {
    public CF1466CTests() {
        super("/p1466/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1466C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
