package p1873;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1873FTests extends AbstractOjTests {
    public CF1873FTests() {
        super("/p1873/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1873A.main(null);
        super.doAssertion();
    }
}