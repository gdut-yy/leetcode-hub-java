package p1692;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1692DTests extends AbstractOjTests {
    public CF1692DTests() {
        super("/p1692/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1692D.main(null);
        super.doAssertion();
    }
}
