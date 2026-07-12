package c428;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc428dTests extends AbstractOjTests {
    public Abc428dTests() {
        super("/c428/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc428_d.main(null);
        super.doAssertion(OUTPUT1);
    }
}
