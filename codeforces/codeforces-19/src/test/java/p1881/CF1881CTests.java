package p1881;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1881CTests extends AbstractOjTests {
    public CF1881CTests() {
        super("/p1881/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1881C.main(null);
        super.doAssertion();
    }
}