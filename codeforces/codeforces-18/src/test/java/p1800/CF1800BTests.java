package p1800;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1800BTests extends AbstractOjTests {
    public CF1800BTests() {
        super("/p1800/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1800B.main(null);
        super.doAssertion();
    }
}
