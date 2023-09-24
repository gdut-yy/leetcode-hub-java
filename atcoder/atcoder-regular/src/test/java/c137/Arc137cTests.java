package c137;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Arc137cTests extends AbstractOjTests {
    public Arc137cTests() {
        super("/c137/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Arc137_c.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Arc137_c.main(null);
        super.doAssertion(OUTPUT2);
    }
}