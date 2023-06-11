package p1485;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1485FTests extends AbstractOjTests {
    public CF1485FTests() {
        super("/p1485/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1485F.main(null);
        super.doAssertion();
    }
}