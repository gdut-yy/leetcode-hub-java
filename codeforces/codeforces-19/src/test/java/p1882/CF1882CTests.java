package p1882;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1882CTests extends AbstractOjTests {
    public CF1882CTests() {
        super("/p1882/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1882C.main(null);
        super.doAssertion(OUTPUT1);
    }
}