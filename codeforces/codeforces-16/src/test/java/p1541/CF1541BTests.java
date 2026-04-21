package p1541;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1541BTests extends AbstractOjTests {
    public CF1541BTests() {
        super("/p1541/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1541B.main(null);
        super.doAssertion(OUTPUT1);
    }
}