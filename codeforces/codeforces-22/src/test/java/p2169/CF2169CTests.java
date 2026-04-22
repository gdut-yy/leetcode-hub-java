package p2169;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2169CTests extends AbstractOjTests {
    public CF2169CTests() {
        super("/p2169/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2169C.main(null);
        super.doAssertion(OUTPUT1);
    }
}