package p1717;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1717CTests extends AbstractOjTests {
    public CF1717CTests() {
        super("/p1717/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1717C.main(null);
        super.doAssertion();
    }
}
