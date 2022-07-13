package p1703;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1703CTests extends AbstractOjTests {
    public CF1703CTests() {
        super("/p1703/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1703C.main(null);
        super.doAssertion();
    }
}
