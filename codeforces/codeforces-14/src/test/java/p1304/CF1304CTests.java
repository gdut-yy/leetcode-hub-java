package p1304;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1304CTests extends AbstractOjTests {
    public CF1304CTests() {
        super("/p1304/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1304C.main(null);
        super.doAssertion(OUTPUT1);
    }
}