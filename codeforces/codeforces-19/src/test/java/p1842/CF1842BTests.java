package p1842;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1842BTests extends AbstractOjTests {
    public CF1842BTests() {
        super("/p1842/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1842B.main(null);
        super.doAssertion();
    }
}