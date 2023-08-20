package p1857;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1857ATests extends AbstractOjTests {
    public CF1857ATests() {
        super("/p1857/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1857A.main(null);
        super.doAssertion();
    }
}