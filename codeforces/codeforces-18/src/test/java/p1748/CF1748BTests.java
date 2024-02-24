package p1748;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1748BTests extends AbstractOjTests {
    public CF1748BTests() {
        super("/p1748/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1748B.main(null);
        super.doAssertion();
    }
}
