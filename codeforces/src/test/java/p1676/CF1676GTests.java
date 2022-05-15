package p1676;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1676GTests extends AbstractOjTests {
    public CF1676GTests() {
        super("/p1676/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1676G.main(null);
        super.doAssertion();
    }
}
