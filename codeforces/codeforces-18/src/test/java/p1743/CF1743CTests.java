package p1743;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF1743CTests extends AbstractOjTests {
    public CF1743CTests() {
        super("/p1743/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1743C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
