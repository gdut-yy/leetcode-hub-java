package p1728;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1728CTests extends AbstractOjTests {
    public CF1728CTests() {
        super("/p1728/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1728C.main(null);
        super.doAssertion();
    }
}