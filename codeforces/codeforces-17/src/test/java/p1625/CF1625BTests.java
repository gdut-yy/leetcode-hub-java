package p1625;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1625BTests extends AbstractOjTests {
    public CF1625BTests() {
        super("/p1625/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1625B.main(null);
        super.doAssertion();
    }
}
