package p1593;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1593BTests extends AbstractOjTests {
    public CF1593BTests() {
        super("/p1593/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1593B.main(null);
        super.doAssertion();
    }
}
