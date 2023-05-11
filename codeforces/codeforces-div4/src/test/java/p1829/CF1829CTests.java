package p1829;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1829CTests extends AbstractOjTests {
    public CF1829CTests() {
        super("/p1829/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1829C.main(null);
        super.doAssertion();
    }
}
