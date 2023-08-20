package p1857;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1857GTests extends AbstractOjTests {
    public CF1857GTests() {
        super("/p1857/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1857G.main(null);
        super.doAssertion();
    }
}