package c306;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc306eTests extends AbstractOjTests {
    public Abc306eTests() {
        super("/c306/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc306_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}
