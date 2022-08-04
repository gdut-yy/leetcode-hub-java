package p1674;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1674CTests extends AbstractOjTests {
    public CF1674CTests() {
        super("/p1674/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1674C.main(null);
        super.doAssertion();
    }
}
