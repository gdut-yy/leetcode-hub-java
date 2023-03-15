package p1669;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1669CTests extends AbstractOjTests {
    public CF1669CTests() {
        super("/p1669/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1669C.main(null);
        super.doAssertion();
    }
}
