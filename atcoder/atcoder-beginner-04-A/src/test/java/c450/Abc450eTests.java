package c450;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc450eTests extends AbstractOjTests {
    public Abc450eTests() {
        super("/c450/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc450_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}
