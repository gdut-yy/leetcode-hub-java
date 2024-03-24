package p1469;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1469CTests extends AbstractOjTests {
    public CF1469CTests() {
        super("/p1469/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1469C.main(null);
        super.doAssertion();
    }
}