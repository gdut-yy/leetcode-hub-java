package p1845;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1845BTests extends AbstractOjTests {
    public CF1845BTests() {
        super("/p1845/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1845B.main(null);
        super.doAssertion();
    }
}