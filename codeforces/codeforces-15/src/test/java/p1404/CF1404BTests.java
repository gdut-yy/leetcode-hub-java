package p1404;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1404BTests extends AbstractOjTests {
    public CF1404BTests() {
        super("/p1404/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1404B.main(null);
        super.doAssertion();
    }
}