package p1799;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import p1792.CF1792C;

import java.io.IOException;

public class CF1799CTests extends AbstractOjTests {
    public CF1799CTests() {
        super("/p1799/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1799C.main(null);
        super.doAssertion(OUTPUT1);
    }
}