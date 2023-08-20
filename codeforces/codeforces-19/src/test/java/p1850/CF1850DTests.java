package p1850;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1850DTests extends AbstractOjTests {
    public CF1850DTests() {
        super("/p1850/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1850D.main(null);
        super.doAssertion();
    }
}