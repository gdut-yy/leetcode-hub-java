package p1891;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1891CTests extends AbstractOjTests {
    public CF1891CTests() {
        super("/p1891/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1891C.main(null);
        super.doAssertion(OUTPUT1);
    }
}