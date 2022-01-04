package p1616;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1616BTests extends AbstractOjTests {
    public CF1616BTests() {
        super("/p1616/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1616B.main(null);
        super.doAssertion();
    }
}
