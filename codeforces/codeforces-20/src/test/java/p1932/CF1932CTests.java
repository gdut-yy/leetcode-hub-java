package p1932;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1932CTests extends AbstractOjTests {
    public CF1932CTests() {
        super("/p1932/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1932C.main(null);
        super.doAssertion(OUTPUT1);
    }
}