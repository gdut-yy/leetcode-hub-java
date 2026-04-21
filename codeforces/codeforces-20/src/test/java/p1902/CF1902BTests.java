package p1902;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1902BTests extends AbstractOjTests {
    public CF1902BTests() {
        super("/p1902/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1902B.main(null);
        super.doAssertion(OUTPUT1);
    }
}