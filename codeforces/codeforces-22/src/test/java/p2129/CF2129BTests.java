package p2129;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2129BTests extends AbstractOjTests {
    public CF2129BTests() {
        super("/p2129/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2129B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
