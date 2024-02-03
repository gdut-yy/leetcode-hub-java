package p1881;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1881GTests extends AbstractOjTests {
    public CF1881GTests() {
        super("/p1881/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1881G.main(null);
        super.doAssertion(OUTPUT1);
    }
}