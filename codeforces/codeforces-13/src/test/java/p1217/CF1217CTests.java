package p1217;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1217CTests extends AbstractOjTests {
    public CF1217CTests() {
        super("/p1217/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1217C.main(null);
        super.doAssertion(OUTPUT1);
    }
}