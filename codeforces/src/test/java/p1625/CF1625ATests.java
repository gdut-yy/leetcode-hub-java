package p1625;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1625ATests extends AbstractOjTests {
    public CF1625ATests() {
        super("/p1625/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1625A.main(null);
        super.doAssertion();
    }
}
