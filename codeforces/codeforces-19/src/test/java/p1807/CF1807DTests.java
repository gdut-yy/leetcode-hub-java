package p1807;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1807DTests extends AbstractOjTests {
    public CF1807DTests() {
        super("/p1807/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1807D.main(null);
        super.doAssertion();
    }
}
