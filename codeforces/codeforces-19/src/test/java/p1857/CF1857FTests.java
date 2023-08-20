package p1857;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1857FTests extends AbstractOjTests {
    public CF1857FTests() {
        super("/p1857/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1857F.main(null);
        super.doAssertion();
    }
}