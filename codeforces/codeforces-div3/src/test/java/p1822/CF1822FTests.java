package p1822;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1822FTests extends AbstractOjTests {
    public CF1822FTests() {
        super("/p1822/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1822F.main(null);
        super.doAssertion();
    }
}