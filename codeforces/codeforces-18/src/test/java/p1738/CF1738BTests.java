package p1738;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1738BTests extends AbstractOjTests {
    public CF1738BTests() {
        super("/p1738/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1738B.main(null);
        super.doAssertion(OUTPUT1);
    }
}