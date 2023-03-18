package c111;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class Arc111bTests extends AbstractOjTests {
    public Arc111bTests() {
        super("/c111/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Arc111_b.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Arc111_b.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Arc111_b.main(null);
        super.doAssertion(OUTPUT3);
    }
}