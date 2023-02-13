package p1790;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1790DTests extends AbstractOjTests {
    public CF1790DTests() {
        super("/p1790/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1790D.main(null);
        super.doAssertion();
    }
}
