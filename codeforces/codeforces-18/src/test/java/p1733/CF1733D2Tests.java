package p1733;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1733D2Tests extends AbstractOjTests {
    public CF1733D2Tests() {
        super("/p1733/D2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1733D2.main(null);
        super.doAssertion();
    }
}