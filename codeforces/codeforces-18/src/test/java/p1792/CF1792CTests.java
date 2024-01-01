package p1792;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1792CTests extends AbstractOjTests {
    public CF1792CTests() {
        super("/p1792/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1792C.main(null);
        super.doAssertion(OUTPUT1);
    }
}