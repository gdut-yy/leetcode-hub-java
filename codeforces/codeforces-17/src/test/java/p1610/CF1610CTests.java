package p1610;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1610CTests extends AbstractOjTests {
    public CF1610CTests() {
        super("/p1610/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1610C.main(null);
        super.doAssertion();
    }
}