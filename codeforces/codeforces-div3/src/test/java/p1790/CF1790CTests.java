package p1790;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1790CTests extends AbstractOjTests {
    public CF1790CTests() {
        super("/p1790/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1790C.main(null);
        super.doAssertion();
    }
}
