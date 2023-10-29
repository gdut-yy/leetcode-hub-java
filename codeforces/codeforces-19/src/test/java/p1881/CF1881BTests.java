package p1881;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1881BTests extends AbstractOjTests {
    public CF1881BTests() {
        super("/p1881/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1881B.main(null);
        super.doAssertion();
    }
}