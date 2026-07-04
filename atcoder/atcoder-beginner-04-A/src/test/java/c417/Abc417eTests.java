package c417;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc417eTests extends AbstractOjTests {
    public Abc417eTests() {
        super("/c417/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc417_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}
