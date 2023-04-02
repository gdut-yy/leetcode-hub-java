package c148;

import base.AbstractOjTests;
import c145.Arc145_a;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Arc148cTests extends AbstractOjTests {
    public Arc148cTests() {
        super("/c148/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Arc148_c.main(null);
        super.doAssertion(OUTPUT1);
    }
}