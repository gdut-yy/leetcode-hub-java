package p1624;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1624CTests extends AbstractOjTests {
    public CF1624CTests() {
        super("/p1624/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1624C.main(null);
        super.doAssertion();
    }
}
