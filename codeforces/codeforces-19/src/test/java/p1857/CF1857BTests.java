package p1857;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1857BTests extends AbstractOjTests {
    public CF1857BTests() {
        super("/p1857/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1857B.main(null);
        super.doAssertion();
    }
}