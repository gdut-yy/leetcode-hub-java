package p1873;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1873HTests extends AbstractOjTests {
    public CF1873HTests() {
        super("/p1873/H/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1873H.main(null);
        super.doAssertion();
    }
}