package p1833;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1833CTests extends AbstractOjTests {
    public CF1833CTests() {
        super("/p1833/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1833C.main(null);
        super.doAssertion();
    }
}