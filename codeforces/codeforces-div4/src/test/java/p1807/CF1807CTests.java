package p1807;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1807CTests extends AbstractOjTests {
    public CF1807CTests() {
        super("/p1807/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1807C.main(null);
        super.doAssertion();
    }
}
