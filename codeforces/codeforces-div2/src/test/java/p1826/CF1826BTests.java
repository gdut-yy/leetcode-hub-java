package p1826;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1826BTests extends AbstractOjTests {
    public CF1826BTests() {
        super("/p1826/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1826B.main(null);
        super.doAssertion();
    }
}