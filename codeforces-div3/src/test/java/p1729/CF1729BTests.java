package p1729;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1729BTests extends AbstractOjTests {
    public CF1729BTests() {
        super("/p1729/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1729B.main(null);
        super.doAssertion();
    }
}
