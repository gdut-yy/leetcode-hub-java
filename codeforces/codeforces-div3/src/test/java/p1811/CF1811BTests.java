package p1811;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1811BTests extends AbstractOjTests {
    public CF1811BTests() {
        super("/p1811/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1811B.main(null);
        super.doAssertion();
    }
}