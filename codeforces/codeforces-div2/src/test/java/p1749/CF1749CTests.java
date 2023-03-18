package p1749;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1749CTests extends AbstractOjTests {
    public CF1749CTests() {
        super("/p1749/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1749C.main(null);
        super.doAssertion();
    }
}