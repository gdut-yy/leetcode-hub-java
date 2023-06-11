package p1744;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1744CTests extends AbstractOjTests {
    public CF1744CTests() {
        super("/p1744/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1744C.main(null);
        super.doAssertion();
    }
}
