package c434;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc434dTests extends AbstractOjTests {
    public Abc434dTests() {
        super("/c434/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc434_d.main(null);
        super.doAssertion(OUTPUT1);
    }
}
