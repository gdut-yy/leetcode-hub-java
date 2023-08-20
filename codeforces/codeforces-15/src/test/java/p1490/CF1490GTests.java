package p1490;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1490GTests extends AbstractOjTests {
    public CF1490GTests() {
        super("/p1490/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1490G.main(null);
        super.doAssertion();
    }
}