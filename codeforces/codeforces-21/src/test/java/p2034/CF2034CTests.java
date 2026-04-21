package p2034;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2034CTests extends AbstractOjTests {
    public CF2034CTests() {
        super("/p2034/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2034C.main(null);
        super.doAssertion(OUTPUT1);
    }
}