package p1833;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1833DTests extends AbstractOjTests {
    public CF1833DTests() {
        super("/p1833/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1833D.main(null);
        super.doAssertion();
    }
}