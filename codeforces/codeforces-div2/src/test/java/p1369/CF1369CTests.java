package p1369;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1369CTests extends AbstractOjTests {
    public CF1369CTests() {
        super("/p1369/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1369C.main(null);
        super.doAssertion();
    }
}