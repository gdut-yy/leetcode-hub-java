package p1857;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1857ETests extends AbstractOjTests {
    public CF1857ETests() {
        super("/p1857/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1857E.main(null);
        super.doAssertion();
    }
}