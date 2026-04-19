package p2117;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2117CTests extends AbstractOjTests {
    public CF2117CTests() {
        super("/p2117/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2117C.main(null);
        super.doAssertion(OUTPUT1);
    }
}