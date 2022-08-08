package p1702;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1702G2Tests extends AbstractOjTests {
    public CF1702G2Tests() {
        super("/p1702/G2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1702G2.main(null);
        super.doAssertion();
    }
}
