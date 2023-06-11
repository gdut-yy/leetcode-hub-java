package p1695;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1695CTests extends AbstractOjTests {
    public CF1695CTests() {
        super("/p1695/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1695C.main(null);
        super.doAssertion();
    }
}