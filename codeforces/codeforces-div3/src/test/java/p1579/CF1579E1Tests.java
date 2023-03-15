package p1579;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1579E1Tests extends AbstractOjTests {
    public CF1579E1Tests() {
        super("/p1579/E1/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1579E1.main(null);
        super.doAssertion();
    }
}
