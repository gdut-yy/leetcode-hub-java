package p1749;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1749BTests extends AbstractOjTests {
    public CF1749BTests() {
        super("/p1749/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1749B.main(null);
        super.doAssertion();
    }
}
