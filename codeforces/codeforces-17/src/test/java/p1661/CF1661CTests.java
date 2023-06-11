package p1661;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1661CTests extends AbstractOjTests {
    public CF1661CTests() {
        super("/p1661/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1661C.main(null);
        super.doAssertion();
    }
}