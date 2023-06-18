package p1738;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1738CTests extends AbstractOjTests {
    public CF1738CTests() {
        super("/p1738/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1738C.main(null);
        super.doAssertion();
    }
}