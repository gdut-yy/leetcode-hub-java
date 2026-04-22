package p2026;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2026BTests extends AbstractOjTests {
    public CF2026BTests() {
        super("/p2026/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2026B.main(null);
        super.doAssertion(OUTPUT1);
    }
}