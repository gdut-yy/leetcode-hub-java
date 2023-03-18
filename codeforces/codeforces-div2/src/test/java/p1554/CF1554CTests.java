package p1554;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1554CTests extends AbstractOjTests {
    public CF1554CTests() {
        super("/p1554/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1554C.main(null);
        super.doAssertion();
    }
}