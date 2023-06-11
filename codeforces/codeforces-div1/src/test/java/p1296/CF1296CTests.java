package p1296;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1296CTests extends AbstractOjTests {
    public CF1296CTests() {
        super("/p1296/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1296C.main(null);
        super.doAssertion();
    }
}