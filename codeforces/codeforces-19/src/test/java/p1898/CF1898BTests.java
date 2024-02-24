package p1898;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1898BTests extends AbstractOjTests {
    public CF1898BTests() {
        super("/p1898/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1898B.main(null);
        super.doAssertion();
    }
}
