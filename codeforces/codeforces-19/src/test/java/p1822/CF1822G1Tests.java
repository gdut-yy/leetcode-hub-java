package p1822;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1822G1Tests extends AbstractOjTests {
    public CF1822G1Tests() {
        super("/p1822/G1/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1822G1.main(null);
        super.doAssertion();
    }
}