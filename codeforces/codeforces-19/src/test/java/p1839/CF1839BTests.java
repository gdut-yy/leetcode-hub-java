package p1839;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1839BTests extends AbstractOjTests {
    public CF1839BTests() {
        super("/p1839/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1839B.main(null);
        super.doAssertion();
    }
}