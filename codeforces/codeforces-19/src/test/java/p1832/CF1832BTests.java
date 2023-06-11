package p1832;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1832BTests extends AbstractOjTests {
    public CF1832BTests() {
        super("/p1832/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1832B.main(null);
        super.doAssertion();
    }
}