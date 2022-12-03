package p1759;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1759CTests extends AbstractOjTests {
    public CF1759CTests() {
        super("/p1759/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1759C.main(null);
        super.doAssertion();
    }
}
