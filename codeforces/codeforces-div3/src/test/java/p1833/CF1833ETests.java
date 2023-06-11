package p1833;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1833ETests extends AbstractOjTests {
    public CF1833ETests() {
        super("/p1833/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1833E.main(null);
        super.doAssertion();
    }
}