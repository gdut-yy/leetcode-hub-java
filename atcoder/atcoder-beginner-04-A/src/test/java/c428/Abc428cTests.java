package c428;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc428cTests extends AbstractOjTests {
    public Abc428cTests() {
        super("/c428/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc428_c.main(null);
        super.doAssertion(OUTPUT1);
    }
}
