package p1873;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1873BTests extends AbstractOjTests {
    public CF1873BTests() {
        super("/p1873/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1873B.main(null);
        super.doAssertion();
    }
}