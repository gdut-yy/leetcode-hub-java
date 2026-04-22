package p2140;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2140CTests extends AbstractOjTests {
    public CF2140CTests() {
        super("/p2140/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2140C.main(null);
        super.doAssertion(OUTPUT1);
    }
}