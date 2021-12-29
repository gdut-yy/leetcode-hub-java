package p1612;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1612CTests extends AbstractOjTests {
    public CF1612CTests() {
        super("/p1612/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1612C.main(null);
        super.doAssertion();
    }
}
