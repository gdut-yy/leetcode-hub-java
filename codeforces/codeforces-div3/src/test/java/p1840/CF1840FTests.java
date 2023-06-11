package p1840;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1840FTests extends AbstractOjTests {
    public CF1840FTests() {
        super("/p1840/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1840F.main(null);
        super.doAssertion();
    }
}