package p1811;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1811DTests extends AbstractOjTests {
    public CF1811DTests() {
        super("/p1811/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1811D.main(null);
        super.doAssertion();
    }
}