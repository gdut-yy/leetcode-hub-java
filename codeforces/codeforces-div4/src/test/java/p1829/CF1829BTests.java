package p1829;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1829BTests extends AbstractOjTests {
    public CF1829BTests() {
        super("/p1829/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1829B.main(null);
        super.doAssertion();
    }
}
