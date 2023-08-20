package p1851;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1851CTests extends AbstractOjTests {
    public CF1851CTests() {
        super("/p1851/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1851C.main(null);
        super.doAssertion();
    }
}