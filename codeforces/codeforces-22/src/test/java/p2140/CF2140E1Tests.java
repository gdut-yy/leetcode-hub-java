package p2140;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2140E1Tests extends AbstractOjTests {
    public CF2140E1Tests() {
        super("/p2140/E1/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2140E1.main(null);
        super.doAssertion(OUTPUT1);
    }
}