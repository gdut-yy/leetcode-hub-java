package p1881;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1881DTests extends AbstractOjTests {
    public CF1881DTests() {
        super("/p1881/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1881D.main(null);
        super.doAssertion();
    }
}