package p1843;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1843BTests extends AbstractOjTests {
    public CF1843BTests() {
        super("/p1843/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1843B.main(null);
        super.doAssertion();
    }
}