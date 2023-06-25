package p1831;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1831CTests extends AbstractOjTests {
    public CF1831CTests() {
        super("/p1831/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1831C.main(null);
        super.doAssertion();
    }
}