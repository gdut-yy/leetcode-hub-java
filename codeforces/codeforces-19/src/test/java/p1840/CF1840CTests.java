package p1840;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1840CTests extends AbstractOjTests {
    public CF1840CTests() {
        super("/p1840/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1840C.main(null);
        super.doAssertion();
    }
}