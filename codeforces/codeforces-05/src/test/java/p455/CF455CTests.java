package p455;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF455CTests extends AbstractOjTests {
    public CF455CTests() {
        super("/p455/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF455C.main(null);
        super.doAssertion(OUTPUT1);
    }
}