package p1826;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1826DTests extends AbstractOjTests {
    public CF1826DTests() {
        super("/p1826/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1826D.main(null);
        super.doAssertion();
    }
}