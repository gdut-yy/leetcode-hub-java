package p1690;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1690BTests extends AbstractOjTests {
    public CF1690BTests() {
        super("/p1690/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1690B.main(null);
        super.doAssertion();
    }
}
