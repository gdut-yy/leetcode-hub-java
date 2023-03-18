package p1379;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1379CTests extends AbstractOjTests {
    public CF1379CTests() {
        super("/p1379/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1379C.main(null);
        super.doAssertion();
    }
}