package p2075;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2075BTests extends AbstractOjTests {
    public CF2075BTests() {
        super("/p2075/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2075B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
