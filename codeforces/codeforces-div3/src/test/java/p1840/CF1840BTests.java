package p1840;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1840BTests extends AbstractOjTests {
    public CF1840BTests() {
        super("/p1840/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1840B.main(null);
        super.doAssertion();
    }
}