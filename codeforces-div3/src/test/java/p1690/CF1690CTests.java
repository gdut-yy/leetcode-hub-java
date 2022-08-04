package p1690;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1690CTests extends AbstractOjTests {
    public CF1690CTests() {
        super("/p1690/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1690C.main(null);
        super.doAssertion();
    }
}
