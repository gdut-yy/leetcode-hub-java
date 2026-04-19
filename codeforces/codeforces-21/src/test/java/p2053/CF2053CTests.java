package p2053;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2053CTests extends AbstractOjTests {
    public CF2053CTests() {
        super("/p2053/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2053C.main(null);
        super.doAssertion(OUTPUT1);
    }
}