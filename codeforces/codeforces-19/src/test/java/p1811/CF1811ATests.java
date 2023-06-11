package p1811;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1811ATests extends AbstractOjTests {
    public CF1811ATests() {
        super("/p1811/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1811A.main(null);
        super.doAssertion();
    }
}