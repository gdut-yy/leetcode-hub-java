package p1807;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1807G2Tests extends AbstractOjTests {
    public CF1807G2Tests() {
        super("/p1807/G2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1807G2.main(null);
        super.doAssertion();
    }
}
