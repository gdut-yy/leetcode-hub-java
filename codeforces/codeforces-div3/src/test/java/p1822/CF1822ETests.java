package p1822;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1822ETests extends AbstractOjTests {
    public CF1822ETests() {
        super("/p1822/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1822E.main(null);
        super.doAssertion();
    }
}