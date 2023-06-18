package p1841;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1841CTests extends AbstractOjTests {
    public CF1841CTests() {
        super("/p1841/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1841C.main(null);
        super.doAssertion();
    }
}