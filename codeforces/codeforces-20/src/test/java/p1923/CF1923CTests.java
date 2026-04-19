package p1923;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1923CTests extends AbstractOjTests {
    public CF1923CTests() {
        super("/p1923/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1923C.main(null);
        super.doAssertion(OUTPUT1);
    }
}