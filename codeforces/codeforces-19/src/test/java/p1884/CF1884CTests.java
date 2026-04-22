package p1884;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1884CTests extends AbstractOjTests {
    public CF1884CTests() {
        super("/p1884/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1884C.main(null);
        super.doAssertion(OUTPUT1);
    }
}