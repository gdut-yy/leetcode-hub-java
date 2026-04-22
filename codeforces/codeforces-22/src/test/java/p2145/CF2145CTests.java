package p2145;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2145CTests extends AbstractOjTests {
    public CF2145CTests() {
        super("/p2145/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2145C.main(null);
        super.doAssertion(OUTPUT1);
    }
}