package p1674;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1674DTests extends AbstractOjTests {
    public CF1674DTests() {
        super("/p1674/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1674D.main(null);
        super.doAssertion();
    }
}
