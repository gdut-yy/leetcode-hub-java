package p1734;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1734CTests extends AbstractOjTests {
    public CF1734CTests() {
        super("/p1734/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1734C.main(null);
        super.doAssertion();
    }
}