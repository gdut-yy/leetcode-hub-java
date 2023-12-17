package p1873;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1873GTests extends AbstractOjTests {
    public CF1873GTests() {
        super("/p1873/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1873G.main(null);
        super.doAssertion();
    }
}