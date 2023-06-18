package p1608;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1608CTests extends AbstractOjTests {
    public CF1608CTests() {
        super("/p1608/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1608C.main(null);
        super.doAssertion();
    }
}