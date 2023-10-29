package p1867;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1867BTests extends AbstractOjTests {
    public CF1867BTests() {
        super("/p1867/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1867B.main(null);
        super.doAssertion();
    }
}