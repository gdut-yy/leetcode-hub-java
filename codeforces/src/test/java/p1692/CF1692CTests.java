package p1692;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1692CTests extends AbstractOjTests {
    public CF1692CTests() {
        super("/p1692/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1692C.main(null);
        super.doAssertion();
    }
}
