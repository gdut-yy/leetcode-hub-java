package p1829;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1829DTests extends AbstractOjTests {
    public CF1829DTests() {
        super("/p1829/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1829D.main(null);
        super.doAssertion();
    }
}
