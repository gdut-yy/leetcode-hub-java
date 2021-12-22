package p1582;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1582BTests extends AbstractOjTests {
    public CF1582BTests() {
        super("p1582/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1582B.main(null);
        super.doAssertion();
    }
}
