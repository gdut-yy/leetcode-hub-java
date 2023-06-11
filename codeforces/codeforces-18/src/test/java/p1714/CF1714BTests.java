package p1714;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1714BTests extends AbstractOjTests {
    public CF1714BTests() {
        super("/p1714/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1714B.main(null);
        super.doAssertion();
    }
}
