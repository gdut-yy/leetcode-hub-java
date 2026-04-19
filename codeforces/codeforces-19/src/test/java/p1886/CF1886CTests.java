package p1886;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1886CTests extends AbstractOjTests {
    public CF1886CTests() {
        super("/p1886/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1886C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
