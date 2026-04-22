package p1765;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1765KTests extends AbstractOjTests {
    public CF1765KTests() {
        super("/p1765/K/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1765K.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1765K.main(null);
        super.doAssertion(OUTPUT2);
    }
}