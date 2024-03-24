package p1582;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1582ETests extends AbstractOjTests {
    public CF1582ETests() {
        super("/p1582/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1582E.main(null);
        super.doAssertion();
    }
}
