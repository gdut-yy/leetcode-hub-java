package p1825;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1825BTests extends AbstractOjTests {
    public CF1825BTests() {
        super("/p1825/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1825B.main(null);
        super.doAssertion();
    }
}