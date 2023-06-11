package p1626;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1626DTests extends AbstractOjTests {
    public CF1626DTests() {
        super("/p1626/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1626D.main(null);
        super.doAssertion();
    }
}