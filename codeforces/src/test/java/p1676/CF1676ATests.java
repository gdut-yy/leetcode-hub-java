package p1676;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1676ATests extends AbstractOjTests {
    public CF1676ATests() {
        super("/p1676/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1676A.main(null);
        super.doAssertion();
    }
}
