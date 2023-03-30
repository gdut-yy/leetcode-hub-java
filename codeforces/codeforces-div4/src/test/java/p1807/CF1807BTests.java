package p1807;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1807BTests extends AbstractOjTests {
    public CF1807BTests() {
        super("/p1807/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1807B.main(null);
        super.doAssertion();
    }
}
