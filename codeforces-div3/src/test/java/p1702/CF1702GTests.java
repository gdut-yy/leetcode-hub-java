package p1702;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1702GTests extends AbstractOjTests {
    public CF1702GTests() {
        super("/p1702/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1702G.main(null);
        super.doAssertion();
    }
}
