package p1996;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1996CTests extends AbstractOjTests {
    public CF1996CTests() {
        super("/p1996/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1996C.main(null);
        super.doAssertion(OUTPUT1);
    }
}