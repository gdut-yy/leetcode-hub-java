package p1922;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1922CTests extends AbstractOjTests {
    public CF1922CTests() {
        super("/p1922/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1922C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
