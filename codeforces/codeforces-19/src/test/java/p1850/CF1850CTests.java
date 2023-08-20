package p1850;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1850CTests extends AbstractOjTests {
    public CF1850CTests() {
        super("/p1850/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1850C.main(null);
        super.doAssertion();
    }
}