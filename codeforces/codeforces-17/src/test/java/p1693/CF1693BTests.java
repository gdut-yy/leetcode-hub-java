package p1693;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1693BTests extends AbstractOjTests {
    public CF1693BTests() {
        super("/p1693/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1693B.main(null);
        super.doAssertion();
    }
}