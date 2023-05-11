package p1822;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1822CTests extends AbstractOjTests {
    public CF1822CTests() {
        super("/p1822/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1822C.main(null);
        super.doAssertion();
    }
}