package p2042;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2042CTests extends AbstractOjTests {
    public CF2042CTests() {
        super("/p2042/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2042C.main(null);
        super.doAssertion(OUTPUT1);
    }
}