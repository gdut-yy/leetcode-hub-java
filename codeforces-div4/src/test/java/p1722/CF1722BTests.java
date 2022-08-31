package p1722;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1722BTests extends AbstractOjTests {
    public CF1722BTests() {
        super("/p1722/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1722B.main(null);
        super.doAssertion();
    }
}
