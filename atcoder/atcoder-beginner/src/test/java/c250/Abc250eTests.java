package c250;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc250eTests extends AbstractOjTests {
    public Abc250eTests() {
        super("/c250/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc250_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}