package p1621;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1621BTests extends AbstractOjTests {
    public CF1621BTests() {
        super("/p1621/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1621B.main(null);
        super.doAssertion();
    }
}
