package p1729;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1729GTests extends AbstractOjTests {
    public CF1729GTests() {
        super("/p1729/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1729G.main(null);
        super.doAssertion();
    }
}