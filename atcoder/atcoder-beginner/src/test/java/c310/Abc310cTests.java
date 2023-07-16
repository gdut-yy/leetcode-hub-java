package c310;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc310cTests extends AbstractOjTests {
    public Abc310cTests() {
        super("/c310/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc310_c.main(null);
        super.doAssertion(OUTPUT1);
    }
}
