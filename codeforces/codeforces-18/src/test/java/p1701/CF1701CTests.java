package p1701;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1701CTests extends AbstractOjTests {
    public CF1701CTests() {
        super("/p1701/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1701C.main(null);
        super.doAssertion();
    }
}
