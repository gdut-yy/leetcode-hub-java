package p1914;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1914CTests extends AbstractOjTests {
    public CF1914CTests() {
        super("/p1914/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1914C.main(null);
        super.doAssertion(OUTPUT1);
    }
}