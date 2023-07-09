package p1845;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1845CTests extends AbstractOjTests {
    public CF1845CTests() {
        super("/p1845/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1845C.main(null);
        super.doAssertion();
    }
}