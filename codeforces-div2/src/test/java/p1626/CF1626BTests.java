package p1626;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1626BTests extends AbstractOjTests {
    public CF1626BTests() {
        super("/p1626/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1626B.main(null);
        super.doAssertion();
    }
}
