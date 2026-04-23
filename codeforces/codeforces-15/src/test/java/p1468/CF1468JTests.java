package p1468;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1468JTests extends AbstractOjTests {
    public CF1468JTests() {
        super("/p1468/J/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1468J.main(null);
        super.doAssertion(OUTPUT1);
    }
}