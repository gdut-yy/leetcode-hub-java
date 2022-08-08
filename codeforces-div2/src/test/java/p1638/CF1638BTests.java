package p1638;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1638BTests extends AbstractOjTests {
    public CF1638BTests() {
        super("/p1638/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1638B.main(null);
        super.doAssertion();
    }
}
