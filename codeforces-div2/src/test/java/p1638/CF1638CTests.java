package p1638;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1638CTests extends AbstractOjTests {
    public CF1638CTests() {
        super("/p1638/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1638C.main(null);
        super.doAssertion();
    }
}
