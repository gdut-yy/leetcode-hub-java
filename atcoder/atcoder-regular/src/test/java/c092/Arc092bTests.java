package c092;

import base.AbstractOjTests;
import c119.Arc119_b;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Arc092bTests extends AbstractOjTests {
    public Arc092bTests() {
        super("/c119/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Arc119_b.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Arc119_b.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Arc119_b.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        Arc119_b.main(null);
        super.doAssertion(OUTPUT4);
    }
}