package p1697;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1697CTests extends AbstractOjTests {
    public CF1697CTests() {
        super("/p1697/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1697C.main(null);
        super.doAssertion();
    }
}