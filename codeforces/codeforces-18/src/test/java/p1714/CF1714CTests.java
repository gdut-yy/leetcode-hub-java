package p1714;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1714CTests extends AbstractOjTests {
    public CF1714CTests() {
        super("/p1714/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1714C.main(null);
        super.doAssertion();
    }
}
