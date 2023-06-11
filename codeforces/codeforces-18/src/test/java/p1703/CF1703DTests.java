package p1703;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1703DTests extends AbstractOjTests {
    public CF1703DTests() {
        super("/p1703/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1703D.main(null);
        super.doAssertion();
    }
}
