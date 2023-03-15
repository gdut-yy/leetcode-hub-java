package p1703;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1703GTests extends AbstractOjTests {
    public CF1703GTests() {
        super("/p1703/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1703G.main(null);
        super.doAssertion();
    }
}
