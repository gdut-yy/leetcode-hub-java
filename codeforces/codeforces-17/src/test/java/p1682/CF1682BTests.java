package p1682;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1682BTests extends AbstractOjTests {
    public CF1682BTests() {
        super("/p1682/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1682B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
