package p1729;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1729ATests extends AbstractOjTests {
    public CF1729ATests() {
        super("/p1729/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1729A.main(null);
        super.doAssertion();
    }
}
