package p1989;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1989CTests extends AbstractOjTests {
    public CF1989CTests() {
        super("/p1989/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1989C.main(null);
        super.doAssertion(OUTPUT1);
    }
}