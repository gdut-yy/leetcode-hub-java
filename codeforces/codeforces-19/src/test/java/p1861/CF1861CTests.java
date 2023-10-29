package p1861;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1861CTests extends AbstractOjTests {
    public CF1861CTests() {
        super("/p1861/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1861C.main(null);
        super.doAssertion();
    }
}