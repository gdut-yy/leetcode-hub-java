package c290;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc290cTests extends AbstractOjTests {
    public Abc290cTests() {
        super("/c290/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc290_c.main(null);
        super.doAssertion(OUTPUT1);
    }
}