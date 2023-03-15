package p1759;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1759BTests extends AbstractOjTests {
    public CF1759BTests() {
        super("/p1759/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1759B.main(null);
        super.doAssertion();
    }
}
