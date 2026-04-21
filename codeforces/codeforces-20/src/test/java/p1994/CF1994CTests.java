package p1994;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1994CTests extends AbstractOjTests {
    public CF1994CTests() {
        super("/p1994/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1994C.main(null);
        super.doAssertion(OUTPUT1);
    }
}