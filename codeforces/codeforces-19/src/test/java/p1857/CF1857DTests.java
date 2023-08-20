package p1857;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1857DTests extends AbstractOjTests {
    public CF1857DTests() {
        super("/p1857/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1857D.main(null);
        super.doAssertion();
    }
}