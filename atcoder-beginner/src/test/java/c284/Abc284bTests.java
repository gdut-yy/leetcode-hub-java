package c284;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc284bTests extends AbstractOjTests {
    public Abc284bTests() {
        super("/c284/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc284_b.main(null);
        super.doAssertion(OUTPUT1);
    }
}