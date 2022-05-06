package p1674;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1674BTests extends AbstractOjTests {
    public CF1674BTests() {
        super("/p1674/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1674B.main(null);
        super.doAssertion();
    }
}
