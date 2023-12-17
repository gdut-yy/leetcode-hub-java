package p1873;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1873DTests extends AbstractOjTests {
    public CF1873DTests() {
        super("/p1873/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1873D.main(null);
        super.doAssertion();
    }
}