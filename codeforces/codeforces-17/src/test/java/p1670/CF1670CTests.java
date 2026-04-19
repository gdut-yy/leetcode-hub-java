package p1670;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1670CTests extends AbstractOjTests {
    public CF1670CTests() {
        super("/p1670/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1670C.main(null);
        super.doAssertion(OUTPUT1);
    }
}