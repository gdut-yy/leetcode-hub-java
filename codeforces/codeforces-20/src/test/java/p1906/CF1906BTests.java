package p1906;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1906BTests extends AbstractOjTests {
    public CF1906BTests() {
        super("/p1906/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1906B.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1906B.main(null);
        super.doAssertion(OUTPUT2);
    }
}
