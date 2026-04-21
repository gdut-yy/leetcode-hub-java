package p1585;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1585CTests extends AbstractOjTests {
    public CF1585CTests() {
        super("/p1585/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1585C.main(null);
        super.doAssertion(OUTPUT1);
    }
}