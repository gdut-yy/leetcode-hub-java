package p1759;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1759GTests extends AbstractOjTests {
    public CF1759GTests() {
        super("/p1759/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1759G.main(null);
        super.doAssertion();
    }
}