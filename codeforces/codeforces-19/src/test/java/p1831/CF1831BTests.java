package p1831;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1831BTests extends AbstractOjTests {
    public CF1831BTests() {
        super("/p1831/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1831B.main(null);
        super.doAssertion();
    }
}