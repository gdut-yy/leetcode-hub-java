package p1873;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1873CTests extends AbstractOjTests {
    public CF1873CTests() {
        super("/p1873/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1873C.main(null);
        super.doAssertion();
    }
}