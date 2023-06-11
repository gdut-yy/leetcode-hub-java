package p1840;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1840ATests extends AbstractOjTests {
    public CF1840ATests() {
        super("/p1840/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1840A.main(null);
        super.doAssertion();
    }
}