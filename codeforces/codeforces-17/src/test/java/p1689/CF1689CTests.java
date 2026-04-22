package p1689;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1689CTests extends AbstractOjTests {
    public CF1689CTests() {
        super("/p1689/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1689C.main(null);
        super.doAssertion(OUTPUT1);
    }
}