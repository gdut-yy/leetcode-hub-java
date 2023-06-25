package p1825;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1825CTests extends AbstractOjTests {
    public CF1825CTests() {
        super("/p1825/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1825C.main(null);
        super.doAssertion();
    }
}