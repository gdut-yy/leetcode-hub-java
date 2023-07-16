package p1700;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1700CTests extends AbstractOjTests {
    public CF1700CTests() {
        super("/p1700/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1700C.main(null);
        super.doAssertion();
    }
}