package p1837;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1837BTests extends AbstractOjTests {
    public CF1837BTests() {
        super("/p1837/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1837B.main(null);
        super.doAssertion();
    }
}