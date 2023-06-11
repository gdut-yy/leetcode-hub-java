package p1650;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1650BTests extends AbstractOjTests {
    public CF1650BTests() {
        super("/p1650/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1650B.main(null);
        super.doAssertion();
    }
}
