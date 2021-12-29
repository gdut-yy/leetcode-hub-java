package p1619;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1619BTests extends AbstractOjTests {
    public CF1619BTests() {
        super("/p1619/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1619B.main(null);
        super.doAssertion();
    }
}
