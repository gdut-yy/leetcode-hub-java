package p1860;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1860CTests extends AbstractOjTests {
    public CF1860CTests() {
        super("/p1860/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1860C.main(null);
        super.doAssertion();
    }
}