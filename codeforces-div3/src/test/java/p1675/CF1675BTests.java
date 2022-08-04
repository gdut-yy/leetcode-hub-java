package p1675;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1675BTests extends AbstractOjTests {
    public CF1675BTests() {
        super("/p1675/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1675B.main(null);
        super.doAssertion();
    }
}
