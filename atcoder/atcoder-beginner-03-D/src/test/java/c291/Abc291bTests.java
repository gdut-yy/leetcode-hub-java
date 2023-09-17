package c291;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc291bTests extends AbstractOjTests {
    public Abc291bTests() {
        super("/c291/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc291_b.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc291_b.main(null);
        super.doAssertion(OUTPUT2);
    }
}