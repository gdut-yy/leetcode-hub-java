package p2009;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2009G2Tests extends AbstractOjTests {
    public CF2009G2Tests() {
        super("/p2009/G2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2009G2.main(null);
        super.doAssertion(OUTPUT1);
    }
}