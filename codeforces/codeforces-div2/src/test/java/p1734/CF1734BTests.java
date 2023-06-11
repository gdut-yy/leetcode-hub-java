package p1734;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1734BTests extends AbstractOjTests {
    public CF1734BTests() {
        super("/p1734/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1734B.main(null);
        super.doAssertion();
    }
}