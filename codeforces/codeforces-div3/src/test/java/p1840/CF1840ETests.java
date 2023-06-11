package p1840;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1840ETests extends AbstractOjTests {
    public CF1840ETests() {
        super("/p1840/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1840E.main(null);
        super.doAssertion();
    }
}