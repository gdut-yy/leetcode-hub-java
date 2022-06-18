package p1692;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1692ATests extends AbstractOjTests {
    public CF1692ATests() {
        super("/p1692/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1692A.main(null);
        super.doAssertion();
    }
}
