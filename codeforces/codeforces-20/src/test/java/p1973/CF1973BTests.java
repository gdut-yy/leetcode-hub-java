package p1973;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1973BTests extends AbstractOjTests {
    public CF1973BTests() {
        super("/p1973/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1973B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
