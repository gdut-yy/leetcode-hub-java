package p1579;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1579GTests extends AbstractOjTests {
    public CF1579GTests() {
        super("/p1579/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1579G.main(null);
        super.doAssertion();
    }
}