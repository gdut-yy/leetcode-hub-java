package p1826;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1826ATests extends AbstractOjTests {
    public CF1826ATests() {
        super("/p1826/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1826A.main(null);
        super.doAssertion();
    }
}