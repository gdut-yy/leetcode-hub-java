package p1931;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1931CTests extends AbstractOjTests {
    public CF1931CTests() {
        super("/p1931/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1931C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
