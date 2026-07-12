package p1694;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1694BTests extends AbstractOjTests {
    public CF1694BTests() {
        super("/p1694/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1694B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
