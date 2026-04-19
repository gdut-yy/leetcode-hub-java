package p2140;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2140E2Tests extends AbstractOjTests {
    public CF2140E2Tests() {
        super("/p2140/E2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2140E2.main(null);
        super.doAssertion(OUTPUT1);
    }
}