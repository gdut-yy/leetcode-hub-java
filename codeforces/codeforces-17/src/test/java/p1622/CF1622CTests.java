package p1622;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1622CTests extends AbstractOjTests {
    public CF1622CTests() {
        super("/p1622/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1622C.main(null);
        super.doAssertion();
    }
}