package p1742;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1742GTests extends AbstractOjTests {
    public CF1742GTests() {
        super("/p1742/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1742G.main(null);
        super.doAssertion();
    }
}
