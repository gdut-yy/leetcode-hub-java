package p1467;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1467CTests extends AbstractOjTests {
    public CF1467CTests() {
        super("/p1467/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1467C.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1467C.main(null);
        super.doAssertion(OUTPUT2);
    }
}