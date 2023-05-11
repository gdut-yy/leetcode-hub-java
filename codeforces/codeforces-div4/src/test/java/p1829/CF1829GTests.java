package p1829;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1829GTests extends AbstractOjTests {
    public CF1829GTests() {
        super("/p1829/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1829G.main(null);
        super.doAssertion();
    }
}
