package c380;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc380eTests extends AbstractOjTests {
    public Abc380eTests() {
        super("/c380/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc380_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}
