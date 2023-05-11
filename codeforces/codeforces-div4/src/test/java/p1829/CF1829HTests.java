package p1829;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1829HTests extends AbstractOjTests {
    public CF1829HTests() {
        super("/p1829/H/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1829H.main(null);
        super.doAssertion();
    }
}
