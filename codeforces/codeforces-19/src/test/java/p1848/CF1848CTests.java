package p1848;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1848CTests extends AbstractOjTests {
    public CF1848CTests() {
        super("/p1848/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1848C.main(null);
        super.doAssertion();
    }
}