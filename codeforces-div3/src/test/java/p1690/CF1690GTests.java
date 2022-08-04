package p1690;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1690GTests extends AbstractOjTests {
    public CF1690GTests() {
        super("/p1690/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1690G.main(null);
        super.doAssertion();
    }
}
