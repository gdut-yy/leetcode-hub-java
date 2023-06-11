package p1840;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1840DTests extends AbstractOjTests {
    public CF1840DTests() {
        super("/p1840/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1840D.main(null);
        super.doAssertion();
    }
}