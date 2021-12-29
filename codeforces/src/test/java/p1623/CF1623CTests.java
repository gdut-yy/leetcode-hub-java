package p1623;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1623CTests extends AbstractOjTests {
    public CF1623CTests() {
        super("/p1623/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1623C.main(null);
        super.doAssertion();
    }
}
