package p1554;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1554BTests extends AbstractOjTests {
    public CF1554BTests() {
        super("/p1554/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1554B.main(null);
        super.doAssertion(OUTPUT1);
    }
}