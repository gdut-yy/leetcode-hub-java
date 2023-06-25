package p1843;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1843CTests extends AbstractOjTests {
    public CF1843CTests() {
        super("/p1843/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1843C.main(null);
        super.doAssertion();
    }
}