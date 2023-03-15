package p1675;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1675ATests extends AbstractOjTests {
    public CF1675ATests() {
        super("/p1675/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1675A.main(null);
        super.doAssertion();
    }
}
