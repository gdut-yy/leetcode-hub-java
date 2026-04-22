package p1900;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1900CTests extends AbstractOjTests {
    public CF1900CTests() {
        super("/p1900/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1900C.main(null);
        super.doAssertion(OUTPUT1);
    }
}