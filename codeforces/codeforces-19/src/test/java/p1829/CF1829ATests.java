package p1829;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1829ATests extends AbstractOjTests {
    public CF1829ATests() {
        super("/p1829/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1829A.main(null);
        super.doAssertion();
    }
}
