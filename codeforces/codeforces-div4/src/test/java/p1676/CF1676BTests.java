package p1676;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1676BTests extends AbstractOjTests {
    public CF1676BTests() {
        super("/p1676/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1676B.main(null);
        super.doAssertion();
    }
}
