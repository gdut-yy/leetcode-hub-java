package p1498;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1498BTests extends AbstractOjTests {
    public CF1498BTests() {
        super("/p1498/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1498B.main(null);
        super.doAssertion(OUTPUT1);
    }
}