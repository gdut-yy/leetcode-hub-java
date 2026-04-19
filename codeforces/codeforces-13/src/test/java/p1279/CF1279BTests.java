package p1279;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1279BTests extends AbstractOjTests {
    public CF1279BTests() {
        super("/p1279/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1279B.main(null);
        super.doAssertion(OUTPUT1);
    }
}