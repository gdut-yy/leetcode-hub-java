package p1676;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1676CTests extends AbstractOjTests {
    public CF1676CTests() {
        super("/p1676/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1676C.main(null);
        super.doAssertion();
    }
}
