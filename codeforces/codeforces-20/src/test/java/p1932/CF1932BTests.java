package p1932;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1932BTests extends AbstractOjTests {
    public CF1932BTests() {
        super("/p1932/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1932B.main(null);
        super.doAssertion(OUTPUT1);
    }
}