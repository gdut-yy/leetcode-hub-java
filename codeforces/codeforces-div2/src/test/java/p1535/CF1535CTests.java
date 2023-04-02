package p1535;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1535CTests extends AbstractOjTests {
    public CF1535CTests() {
        super("/p1535/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1535C.main(null);
        super.doAssertion();
    }
}