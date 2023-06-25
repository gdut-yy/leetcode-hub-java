package p1825;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1825ATests extends AbstractOjTests {
    public CF1825ATests() {
        super("/p1825/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1825A.main(null);
        super.doAssertion();
    }
}