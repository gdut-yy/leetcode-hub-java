package p1443;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1443CTests extends AbstractOjTests {
    public CF1443CTests() {
        super("/p1443/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1443C.main(null);
        super.doAssertion(OUTPUT1);
    }
}