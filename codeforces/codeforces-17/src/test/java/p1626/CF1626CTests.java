package p1626;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import p1613.CF1613D;

import java.io.IOException;

public class CF1626CTests extends AbstractOjTests {
    public CF1626CTests() {
        super("/p1626/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1626C.main(null);
        super.doAssertion();
    }
}