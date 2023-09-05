package p1862;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1862CTests extends AbstractOjTests {
    public CF1862CTests() {
        super("/p1862/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1862C.main(null);
        super.doAssertion();
    }
}