package c304;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc304eTests extends AbstractOjTests {
    public Abc304eTests() {
        super("/c304/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc304_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}
