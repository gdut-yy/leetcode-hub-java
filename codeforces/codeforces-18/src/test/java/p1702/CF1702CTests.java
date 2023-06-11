package p1702;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1702CTests extends AbstractOjTests {
    public CF1702CTests() {
        super("/p1702/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1702C.main(null);
        super.doAssertion();
    }
}
