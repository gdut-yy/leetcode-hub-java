package p1842;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1842CTests extends AbstractOjTests {
    public CF1842CTests() {
        super("/p1842/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1842C.main(null);
        super.doAssertion();
    }
}