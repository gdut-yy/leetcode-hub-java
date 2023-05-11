package p1822;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1822BTests extends AbstractOjTests {
    public CF1822BTests() {
        super("/p1822/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1822B.main(null);
        super.doAssertion();
    }
}