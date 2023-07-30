package c311;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc311eTests extends AbstractOjTests {
    public Abc311eTests() {
        super("/c311/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc311_e.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc311_e.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Abc311_e.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    @Disabled("[ERROR] Java heap space")
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        Abc311_e.main(null);
        super.doAssertion(OUTPUT4);
    }
}
