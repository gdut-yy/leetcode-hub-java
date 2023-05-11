package p1822;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1822ATests extends AbstractOjTests {
    public CF1822ATests() {
        super("/p1822/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1822A.main(null);
        super.doAssertion();
    }
}