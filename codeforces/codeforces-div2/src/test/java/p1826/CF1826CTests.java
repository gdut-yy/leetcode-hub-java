package p1826;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1826CTests extends AbstractOjTests {
    public CF1826CTests() {
        super("/p1826/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1826C.main(null);
        super.doAssertion();
    }
}