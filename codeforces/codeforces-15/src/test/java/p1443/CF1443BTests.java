package p1443;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1443BTests extends AbstractOjTests {
    public CF1443BTests() {
        super("/p1443/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1443B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
