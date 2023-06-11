package p1638;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1638ATests extends AbstractOjTests {
    public CF1638ATests() {
        super("/p1638/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1638A.main(null);
        super.doAssertion();
    }
}
