package p1676;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1676H1Tests extends AbstractOjTests {
    public CF1676H1Tests() {
        super("/p1676/H1/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1676H1.main(null);
        super.doAssertion();
    }
}
