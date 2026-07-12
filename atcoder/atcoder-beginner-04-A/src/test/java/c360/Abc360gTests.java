package c360;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc360gTests extends AbstractOjTests {
    public Abc360gTests() {
        super("/c360/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc360_g.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc360_g.main(null);
        super.doAssertion(OUTPUT2);
    }
}
