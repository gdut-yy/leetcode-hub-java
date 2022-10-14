package p1729;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1729DTests extends AbstractOjTests {
    public CF1729DTests() {
        super("/p1729/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1729D.main(null);
        super.doAssertion();
    }
}
