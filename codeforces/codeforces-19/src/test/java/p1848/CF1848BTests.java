package p1848;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1848BTests extends AbstractOjTests {
    public CF1848BTests() {
        super("/p1848/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1848B.main(null);
        super.doAssertion();
    }
}