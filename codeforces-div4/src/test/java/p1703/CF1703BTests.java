package p1703;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1703BTests extends AbstractOjTests {
    public CF1703BTests() {
        super("/p1703/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1703B.main(null);
        super.doAssertion();
    }
}
