package p1878;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1878CTests extends AbstractOjTests {
    public CF1878CTests() {
        super("/p1878/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1878C.main(null);
        super.doAssertion();
    }
}