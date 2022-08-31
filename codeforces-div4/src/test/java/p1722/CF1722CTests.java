package p1722;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1722CTests extends AbstractOjTests {
    public CF1722CTests() {
        super("/p1722/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1722C.main(null);
        super.doAssertion();
    }
}
