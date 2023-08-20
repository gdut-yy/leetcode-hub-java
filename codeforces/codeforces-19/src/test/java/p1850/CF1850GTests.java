package p1850;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1850GTests extends AbstractOjTests {
    public CF1850GTests() {
        super("/p1850/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1850G.main(null);
        super.doAssertion();
    }
}