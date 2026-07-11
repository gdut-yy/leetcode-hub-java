package p2144;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2144CTests extends AbstractOjTests {
    public CF2144CTests() {
        super("/p2144/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2144C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
