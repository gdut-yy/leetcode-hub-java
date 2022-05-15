package p1676;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1676H2Tests extends AbstractOjTests {
    public CF1676H2Tests() {
        super("/p1676/H2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1676H2.main(null);
        super.doAssertion();
    }
}
