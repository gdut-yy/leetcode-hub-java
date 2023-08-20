package p1851;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1851BTests extends AbstractOjTests {
    public CF1851BTests() {
        super("/p1851/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1851B.main(null);
        super.doAssertion();
    }
}