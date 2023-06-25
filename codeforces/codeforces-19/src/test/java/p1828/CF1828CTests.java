package p1828;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1828CTests extends AbstractOjTests {
    public CF1828CTests() {
        super("/p1828/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1828C.main(null);
        super.doAssertion();
    }
}