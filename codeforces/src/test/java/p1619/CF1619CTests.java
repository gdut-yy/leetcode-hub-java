package p1619;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1619CTests extends AbstractOjTests {
    public CF1619CTests() {
        super("p1619/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1619C.main(null);
        super.doAssertion();
    }
}
