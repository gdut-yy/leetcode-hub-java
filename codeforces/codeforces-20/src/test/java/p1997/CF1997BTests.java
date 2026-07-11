package p1997;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1997BTests extends AbstractOjTests {
    public CF1997BTests() {
        super("/p1997/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1997B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
