package p1904;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1904CTests extends AbstractOjTests {
    public CF1904CTests() {
        super("/p1904/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1904C.main(null);
        super.doAssertion(OUTPUT1);
    }
}