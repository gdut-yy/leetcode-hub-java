package p1846;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1846GTests extends AbstractOjTests {
    public CF1846GTests() {
        super("/p1846/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1846G.main(null);
        super.doAssertion();
    }
}