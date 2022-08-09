package p1616;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1616CTests extends AbstractOjTests {
    public CF1616CTests() {
        super("/p1616/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1616C.main(null);
        super.doAssertion();
    }
}
