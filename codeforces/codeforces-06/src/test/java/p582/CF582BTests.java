package p582;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF582BTests extends AbstractOjTests {
    public CF582BTests() {
        super("/p582/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF582B.main(null);
        super.doAssertion(OUTPUT1);
    }
}