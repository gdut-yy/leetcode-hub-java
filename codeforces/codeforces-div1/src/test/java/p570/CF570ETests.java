package p570;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF570ETests extends AbstractOjTests {
    public CF570ETests() {
        super("/p570/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF570E.main(null);
        super.doAssertion();
    }
}