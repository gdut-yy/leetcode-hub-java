package p1851;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1851ATests extends AbstractOjTests {
    public CF1851ATests() {
        super("/p1851/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1851A.main(null);
        super.doAssertion();
    }
}