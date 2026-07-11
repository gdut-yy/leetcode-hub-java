package p2202;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2202BTests extends AbstractOjTests {
    public CF2202BTests() {
        super("/p2202/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2202B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
