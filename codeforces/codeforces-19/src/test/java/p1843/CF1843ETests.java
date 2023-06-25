package p1843;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1843ETests extends AbstractOjTests {
    public CF1843ETests() {
        super("/p1843/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1843E.main(null);
        super.doAssertion();
    }
}