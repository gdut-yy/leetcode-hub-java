package p1832;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1832CTests extends AbstractOjTests {
    public CF1832CTests() {
        super("/p1832/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1832C.main(null);
        super.doAssertion();
    }
}